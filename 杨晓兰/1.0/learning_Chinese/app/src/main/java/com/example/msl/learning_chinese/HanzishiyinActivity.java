package com.example.msl.learning_chinese;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HanzishiyinActivity extends AppCompatActivity {

    private ImageView ivReturn;
    private TextView tvQuestion;
    private RadioGroup radioGroup;
    private int passed;//学过的数量
    private int button;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private List<Question> qlist = new ArrayList<>();
    private OkHttpClient okHttpClient = new OkHttpClient();
    private String rsp;
    SoundPool sp;
    HashMap<Integer, Integer> hm;//声明HashMap来存放声音文件

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Type type = new TypeToken<List<Question>>(){}.getType();
                    qlist = new Gson().fromJson(rsp,type);

                    tvQuestion.setText(qlist.get(0).getWord());
                    rb1.setText(qlist.get(0).getAnswer1());
                    rb2.setText(qlist.get(0).getAnswer2());
                    rb3.setText(qlist.get(0).getAnswer3());
                    rb4.setText(qlist.get(0).getAnswer4());
                    passed=0;
                    break;
                case 2:
                    rb1.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 3:
                    rb2.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 4:
                    rb3.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
                case 5:
                    rb4.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                    if (msg.arg1==1){
                        nextQuestion();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanzishiyin);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        initViews();
        initSoundPool();
        reviewed();

        //点击返回复习页面
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(HanzishiyinActivity.this, ReviewActivity.class);
                startActivity(i);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd_answer1:
                        if (qlist.get(passed).getAnswer() == 1){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(2,1);
                        }else{
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(2,2);
                        }
                        break;
                    case R.id.rd_answer2:
                        if (qlist.get(passed).getAnswer() == 2){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb2.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(3,1);
                        }else{
                            rb2.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(3,2);
                        }

                        break;
                    case R.id.rd_answer3:
                        if (qlist.get(passed).getAnswer() == 3){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb3.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(4,1);
                        }else{
                            rb3.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(4,2);
                        }
                        break;
                    case R.id.rd_answer4:
                        if (qlist.get(passed).getAnswer() == 4){
                            sp.play(hm.get(2),1, 1, 0, 0, 1);
                            rb1.setButtonDrawable(getResources().getDrawable(R.drawable.trueoption));
                            passed++;
                            setButton(5,1);
                        }else{
                            rb4.setButtonDrawable(getResources().getDrawable(R.drawable.optionfalse));
                            sp.play(hm.get(1),1,1,0,0,1);
                            setButton(5,2);
                        }
                        break;

                }

            }
        });
    }

    public void initViews(){
        ivReturn = findViewById(R.id.iv_review_return);
        tvQuestion = findViewById(R.id.tv_question);
        radioGroup = findViewById(R.id.rg_tingyinxuanzi);
        rb1 = findViewById(R.id.rd_answer1);
        rb2 = findViewById(R.id.rd_answer2);
        rb3 = findViewById(R.id.rd_answer3);
        rb4 = findViewById(R.id.rd_answer4);
    }

    public void reviewed(){
        Request requestBlog = new Request.Builder()
                .url(Constant.BASE_URL + "han?userId="+Constant.USER_STATUS.getId())
                .build();
        try {
            Response response = okHttpClient.newCall(requestBlog).execute();
            rsp = response.body().string();
            Log.e("rrr", rsp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Message msg = new Message();
        msg.what = 1;
        mainHandle.sendMessage(msg);
    }

    public void setButton(int what,int tf){
        Message msg = new Message();
        msg.what = what;
        msg.arg1 = tf;
        mainHandle.sendMessageDelayed(msg,500);
    }

    private void initSoundPool() {//初始化声音池
        sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);//创建SoundPool对象
        hm = new HashMap<Integer, Integer>();//创建HashMap对象
        //加载声音文件，并且设置为1号声音放入hm中
        hm.put(1, sp.load(this, R.raw.wronganswer, 1));
        hm.put(2,sp.load(this, R.raw.trueanswer,1));
    }

    private void nextQuestion(){
        if (passed == qlist.size()){
            ReviewDialog reviewDialog = new ReviewDialog();
            reviewDialog.setCancelable(false);
            reviewDialog.show(getSupportFragmentManager(),"endTag");
        }else{
            tvQuestion.setText(qlist.get(passed).getWord());
            rb1.setText(qlist.get(passed).getAnswer1());
            rb2.setText(qlist.get(passed).getAnswer2());
            rb3.setText(qlist.get(passed).getAnswer3());
            rb4.setText(qlist.get(passed).getAnswer4());
        }
    }

}
