package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReviewFragment extends Fragment {

    private OkHttpClient okHttpClient = new OkHttpClient();
    private TextView reviewedNum;
    private TextView goalNum;
    private LinearLayout tingyinxuanzi;
    private LinearLayout xuancitiankong;
    private LinearLayout hanzishiyin;
    private LinearLayout zicisuting;
    private String rsp;
    private int num;

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    reviewedNum.setText(rsp);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_review,
                container, false);
        findViews(view);
        bindListener();

        goalNum.setText("10");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        new Thread(new Runnable(){
            @Override
            public void run() {
                Request requestBlog = new Request.Builder()
                        .url(Constant.BASE_URL + "getCount?userId="+Constant.USER_STATUS.getId())
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
        }).start();

        return view;
    }

    /**
     * 获取视图
     */
    public void findViews(View view){
        reviewedNum = view.findViewById(R.id.tv_reviewed);
        goalNum = view.findViewById(R.id.tv_goal);
        tingyinxuanzi = view.findViewById(R.id.ll_tingyinxuanzi);
        xuancitiankong = view.findViewById(R.id.ll_xuancitiankong);
        hanzishiyin = view.findViewById(R.id.ll_hanzishiyin);
        zicisuting = view.findViewById(R.id.ll_zicisuting);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        hanzishiyin.setOnClickListener(myListener);
        tingyinxuanzi.setOnClickListener(myListener);
        xuancitiankong.setOnClickListener(myListener);
        zicisuting.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_tingyinxuanzi:
                    Intent intent = new Intent(getActivity(),TingyinxuanziActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_hanzishiyin:
                    Intent intent1 = new Intent(getActivity(),HanzishiyinActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.ll_xuancitiankong:
                    Intent intent2 = new Intent(getActivity(),TiActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.ll_zicisuting:
                    Intent intent3 = new Intent(getActivity(),StuActivity.class);
                    startActivity(intent3);
                    break;
            }
        }
    }

}
