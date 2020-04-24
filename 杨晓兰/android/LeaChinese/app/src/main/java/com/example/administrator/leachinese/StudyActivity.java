package com.example.administrator.leachinese;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
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

import static com.example.administrator.leachinese.Constant.AUDIO_URL;

public class StudyActivity extends AppCompatActivity {
    private TextView tvWord;
    private TextView tvPinyin;
    private LinearLayout llStudy;
    private Gson gson;
    private List<Word> wordList;
    private Intent intent;
    private int pageNum;
    private int wordNum;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        findView();
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
        playAudio();
    }

    private void findView() {
        tvWord = findViewById(R.id.tv_word);
        tvPinyin = findViewById(R.id.tv_pinyin);
        llStudy = findViewById(R.id.ll_study);
        llStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), WordDetailsActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
                StudyActivity.this.finish();
            }
        });
    }

    private void playAudio() {
        mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse(AUDIO_URL + wordList.get(wordNum).getAudio());
        try {
            mediaPlayer.setDataSource(this, uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 创建一个AlertDialog构造器，构造者
            AlertDialog.Builder adBuilder = new AlertDialog
                    .Builder(StudyActivity.this);
            // 对构造器进行设置
            adBuilder.setTitle("提示");
            adBuilder.setMessage("您确定要退出学习吗？");
            // 积极  Positive
            // 消极  Negative
            // 中立  Neutral
            adBuilder.setPositiveButton("退出",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            intent = new Intent(StudyActivity.this, MainActivity.class);
                            startActivity(intent);
                            StudyActivity.this.finish();
                        }
                    });
            adBuilder.setNegativeButton("继续学习",
                    null);
            // 通过构造器创建AlertDialog
            AlertDialog alertDialog = adBuilder.create();
            // 设置对话框不能被取消（点击界面其它地方，对话框自动关闭）
            alertDialog.setCancelable(false);
            alertDialog.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
