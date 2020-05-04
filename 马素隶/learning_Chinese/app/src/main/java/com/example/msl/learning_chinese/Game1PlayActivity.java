package com.example.msl.learning_chinese;

import android.app.Activity;
import android.content.Context;

import android.nfc.FormatException;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Game1PlayActivity extends AppCompatActivity {
    private List<Msg> mMsgs;
    private MsgDaoUtil mMsgDaoUtil;
    private ChatAdapter mAdapter;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private RecyclerView mRvChatList;
    private EditText mEtContent;
    private Button mBtSend;
    private Idiom idiom;
    private String rsp;
    private  Runnable mrunnable;
    private Handler handler = new Handler();
    private String content;
    private TTSUtility ttsUtility ;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            addMsg(new Msg(null, "欢迎来到成语接龙游戏，现在是你先开始，还是我先开始", Msg.TYPE_BLE, df.format(new java.util.Date())));
            ttsUtility.speaking("欢迎来到成语接龙游戏，现在是你先开始，还是我先开始");
        }
    };

    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    idiom = new Gson().fromJson(rsp,Idiom.class);
                    mrunnable = new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            addMsg(new Msg(null, "我出的成语是："+idiom.getIdiom(), Msg.TYPE_BLE, df.format(new java.util.Date())));
                            ttsUtility.speaking("我出的成语是："+idiom.getIdiom());
                        }
                    };
                    break;
                case 3:
                    idiom = new Gson().fromJson(rsp,Idiom.class);
                    mrunnable = new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            addMsg(new Msg(null, "那我再来说一个好了："+idiom.getIdiom(), Msg.TYPE_BLE, df.format(new java.util.Date())));
                            ttsUtility.speaking("那我再来说一个好了："+idiom.getIdiom());
                        }
                    };
                    break;
                case 2:
                    if (rsp.equals("{\"r\":\"fail\"}")){
                        mrunnable = new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                addMsg(new Msg(null, "你说的这个成语我好像不认识，重新再发一个吧", Msg.TYPE_BLE, df.format(new java.util.Date())));
                                ttsUtility.speaking("你说的这个成语我好像不认识，重新再发一个吧");
                            }
                        };
                    }else{
                        idiom = new Gson().fromJson(rsp,Idiom.class);
                        mrunnable = new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                addMsg(new Msg(null, idiom.getIdiom(), Msg.TYPE_BLE, df.format(new java.util.Date())));
                                ttsUtility.speaking(idiom.getIdiom());
                            }
                        };
                    }
                    break;
            }
            mhandler.post(mrunnable);
            showMsg();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_play_acitivity);
        ttsUtility = new TTSUtility(this);
        findViews();
        bindListener();
        mMsgDaoUtil = new MsgDaoUtil(this);
        showMsg();
        handler.post(runnable);

    }

    public void showMsg(){
        //加载历史聊天记录
        mMsgs = mMsgDaoUtil.queryAllMsg();
        Log.e("msgs",mMsgs.toString());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRvChatList.setLayoutManager(linearLayoutManager);
        mAdapter = new ChatAdapter(this, mMsgs);
        mRvChatList.setAdapter(mAdapter);
        //初试加载历史记录呈现最新消息
        mRvChatList.scrollToPosition(mAdapter.getItemCount() - 1);
        //设置下滑隐藏软键盘
        mRvChatList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < -10) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mEtContent.getWindowToken(), 0);
                }
            }
        });
    }


    private boolean addMsg(Msg msg) {
        Log.e("msg",msg.toString());
        mAdapter.addItem(msg);
        return mMsgDaoUtil.insertMsg(msg);

    }


    /**
     * 获取视图
     */
    public void findViews() {
        mRvChatList = findViewById(R.id.rv_chatList);
        mEtContent = findViewById(R.id.et_content);
        mBtSend = findViewById(R.id.bt_send);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener() {
        MyListener myListener = new MyListener();
        mBtSend.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_left:
                    finish();
                    break;
                case R.id.bt_send:
                    content = mEtContent.getText().toString();
                    Msg msg = new Msg(null, content, Msg.TYPE_PHONE, df.format(new java.util.Date()));
                    addMsg(msg);
                    if (msg.getContent().contains("我")) {

                    } else if (msg.getContent().contains("你")) {
                        reply(1);
                    } else if(msg.getContent().contains("不会")){
                        reply(2);
                    } else {
                        phrase();
                    }
                    showMsg();
                    mEtContent.setText("");
            }
        }
    }
    /**
     * 向服务器端发送内容
     */
    private void reply(int i) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                    .url(Constant.GAME_ONE + "/rand")//设置网络请求的地址
                    .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                rsp = response.body().string();
                Log.e("rsp", rsp);
                Message msg = new Message();
                if (i==1) {
                    msg.what = 1;
                }else if(i==2){
                    msg.what=3;
                }
                mhandler.sendMessage(msg);

            }
        });

    }

    /**
     * 实现成语接龙
     */
    private void phrase() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request  = new Request.Builder()
                .url(Constant.GAME_ONE + "/reply/"+content)//设置网络请求的地址
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                rsp = response.body().string();
                Log.e("rsp", rsp);
                Message msg = new Message();
                msg.what = 2;
                mhandler.sendMessage(msg);

            }
        });

    }
}
