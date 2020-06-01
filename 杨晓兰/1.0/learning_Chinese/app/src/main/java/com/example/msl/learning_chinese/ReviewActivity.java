package com.example.msl.learning_chinese;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ReviewActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient = new OkHttpClient();
    private TextView reviewedNum;
    private TextView goalNum;
    private LinearLayout tingyinxuanzi;
    private LinearLayout xuancitiankong;
    private LinearLayout hanzishiyin;
    private LinearLayout zicisuting;
    private String rsp;


    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    try {
                        JSONObject jsonObject = new JSONObject(rsp);
                        reviewedNum.setText(String.valueOf(jsonObject.optInt("reviewedTime")));
                        goalNum.setText(String.valueOf(jsonObject.optInt("goalTime")));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        reviewedNum = findViewById(R.id.tv_reviewed);
        goalNum = findViewById(R.id.tv_goal);
        tingyinxuanzi = findViewById(R.id.ll_tingyinxuanzi);
        xuancitiankong = findViewById(R.id.ll_xuancitiankong);
        hanzishiyin = findViewById(R.id.ll_hanzishiyin);
        zicisuting = findViewById(R.id.ll_zicisuting);

        User u = new User();
        u.setId(1);
        Constant.USER_STATUS = u;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //initView();

        getReviewedTime();

        tingyinxuanzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ReviewActivity.this,TingyinxuanziActivity.class);
                startActivity(i);
            }
        });
        hanzishiyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ReviewActivity.this,HanzishiyinActivity.class);
                startActivity(i);
            }
        });
    }

    public void initView (View view){
        reviewedNum = findViewById(R.id.tv_reviewed);
        goalNum = view.findViewById(R.id.tv_goal);
        tingyinxuanzi = view.findViewById(R.id.ll_tingyinxuanzi);
        xuancitiankong = view.findViewById(R.id.ll_xuancitiankong);
        hanzishiyin = view.findViewById(R.id.ll_hanzishiyin);
        zicisuting = view.findViewById(R.id.ll_zicisuting);
    }

    //获取已复习的时间和目标复习时间
    private void getReviewedTime(){
        Request requestBlog = new Request.Builder()
                .url(Constant.BASE_URL + "getTime?userId="+Constant.USER_STATUS.getId())
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


}
