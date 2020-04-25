package com.example.msl.learning_chinese;

import android.app.Activity;
import android.content.Context;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.List;

public class Game1PlayActivity extends AppCompatActivity {
    private List<Msg> mMsgs;
    private MsgDaoUtil mMsgDaoUtil;
    private ChatAdapter mAdapter;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private RecyclerView mRvChatList;
    private EditText mEtContent;
    private Button mBtSend;

    //后台定时5s发送数据
    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            addMsg(new Msg(null, "来数据了！", Msg.TYPE_BLE, df.format(new java.util.Date())));
            handler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_play_acitivity);
        findViews();
        bindListener();
        mMsgDaoUtil = new MsgDaoUtil(this);
        showMsg();
        handler.postDelayed(runnable, 5000);
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
                    String content = mEtContent.getText().toString();
                    addMsg(new Msg(null, content, Msg.TYPE_PHONE, df.format(new java.util.Date())));
                    showMsg();
                    mEtContent.setText("");
            }
        }


    }
}
