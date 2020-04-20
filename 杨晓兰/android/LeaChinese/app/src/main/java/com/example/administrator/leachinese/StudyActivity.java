package com.example.administrator.leachinese;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class StudyActivity extends AppCompatActivity{
    private TextView tvWord;
    private TextView tvPinyin;
    private LinearLayout llStudy;
    private OkHttpClient okHttpClient;
    private Gson gson;
    private List<Word> wordList;
    private Intent intent;
    private int pageNum;
    private int wordNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        findView();
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        pageNum = Constant.USER_STATUS.getStudiedTag();
        wordNum = Constant.USER_STATUS.getNumberTag();
        intent = getIntent();
        String intentStr = intent.getStringExtra("wordList");
        wordList = gson.fromJson(intentStr, new TypeToken<List<Word>>() {
        }.getType());
        tvWord.setText(wordList.get(wordNum).getWord());
        tvPinyin.setText(wordList.get(wordNum).getPinyin());
    }
    private void findView(){
        tvWord = findViewById(R.id.tv_word);
        tvPinyin = findViewById(R.id.tv_pinyin);
        llStudy = findViewById(R.id.ll_study);
        llStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent  = new Intent(v.getContext(),WordDetailsActivity.class);
                intent.putExtra("word",gson.toJson(wordList.get(wordNum)));
                startActivity(intent);
            }
        });
    }

}
