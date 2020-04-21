package com.example.administrator.leachinese;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imgHead;
    private TextView tvCur;
    private TextView tvGoal;
    private Button btnStart;
    private OkHttpClient okHttpClient;
    private Gson gson;
    private List<Word> wordList;
    private Intent intent;
    private int pageNum;
    private int wordNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        pageNum = Constant.USER_STATUS.getStudiedTag();
        wordNum = Constant.USER_STATUS.getNumberTag();
        //头像设置
        RequestOptions options = new RequestOptions()
                .circleCrop();//圆形剪裁
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.head)//图片资源id
                .into(imgHead);
        tvCur.setText(""+wordNum);
        getWordList();
    }

    private void findViews() {
        imgHead = findViewById(R.id.img_head);
        tvCur = findViewById(R.id.tv_cur);
        tvGoal = findViewById(R.id.tv_goal);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(),StudyActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
            }
        });
    }

    /*
    获取今日单词列表
    */
    private void getWordList() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/list?pageNum=" + pageNum)//设置网络请求的URL地址
                .build();
        //3.创建Call对象
        Call call = okHttpClient.newCall(request);
        //4.发送请求
        //异步请求，不需要创建线程
        call.enqueue(new Callback() {
            @Override
            //请求失败时回调
            public void onFailure(Call call, IOException e) {
                Log.e("failure", "error");
                Log.e("error",e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
                wordList = gson.fromJson(reStr, new TypeToken<List<Word>>() {
                }.getType());
                runOnUiThread(new Runnable() {
                    public void run() {
                        tvGoal.setText("/"+wordList.size());
                    }
                });

            }
        });
    }

}
