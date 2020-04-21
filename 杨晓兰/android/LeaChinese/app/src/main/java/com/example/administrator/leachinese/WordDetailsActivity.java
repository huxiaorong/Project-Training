package com.example.administrator.leachinese;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import static com.example.administrator.leachinese.Constant.AUDIO_URL;
import static com.example.administrator.leachinese.Constant.USER_STATUS;

public class WordDetailsActivity extends AppCompatActivity {
    private TextView tvWord;
    private TextView tvPinyin;
    private TextView tvExplanation;
    private TextView tvSentence1;
    private TextView tvPinyin1;
    private TextView tvSentence2;
    private TextView tvPinyin2;
    private TextView tvSentence3;
    private TextView tvPinyin3;
    private ImageView imgPlay;
    private ImageView imgCollection;
    private Button btnKnow;
    private Button btnNo;
    private Gson gson;
    private Intent intent;
    private List<Word> wordList;
    private Word word;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);
        findView();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        intent = getIntent();
        String intentStr = intent.getStringExtra("wordList");
        Log.e("WordDetailsActivity",intentStr);
        wordList = gson.fromJson(intentStr, new TypeToken<List<Word>>() {
        }.getType());
        word = wordList.get(Constant.USER_STATUS.getNumberTag());
        initDate();
        playAudio();
    }
    private void findView(){
        tvWord = findViewById(R.id.tv_word);
        tvPinyin = findViewById(R.id.tv_pinyin);
        tvExplanation = findViewById(R.id.tv_explanation);
        tvSentence1 = findViewById(R.id.tv_sentence1);
        tvPinyin1 = findViewById(R.id.tv_pinyin1);
        tvSentence2 = findViewById(R.id.tv_sentence2);
        tvPinyin2 = findViewById(R.id.tv_pinyin2);
        tvSentence3 = findViewById(R.id.tv_sentence3);
        tvPinyin3 = findViewById(R.id.tv_pinyin3);
        imgPlay = findViewById(R.id.img_play);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();//暂停播放
                }else {
                    mediaPlayer.start();
                }
            }
        });
        imgCollection = findViewById(R.id.img_collection);
        btnKnow = findViewById(R.id.btn_know);
        btnKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (USER_STATUS.getNumberTag()<wordList.size()){
                    USER_STATUS.setNumberTag(USER_STATUS.getNumberTag()+1);
                    intent = new Intent(v.getContext(),StudyActivity.class);
                    intent.putExtra("wordList",gson.toJson(wordList));
                    startActivity(intent);
                }
            }
        });
        btnNo = findViewById(R.id.btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (USER_STATUS.getNumberTag()<wordList.size()){
                    USER_STATUS.setNumberTag(USER_STATUS.getNumberTag()+1);
                    intent = new Intent(v.getContext(),StudyActivity.class);
                    intent.putExtra("wordList",gson.toJson(wordList));
                    startActivity(intent);
                }
            }
        });
    }
    private void initDate(){
        tvWord.setText(word.getWord());
        tvPinyin.setText(word.getPinyin());
        tvExplanation.setText(word.getExplanation());
        tvSentence1.setText(word.getSentence1());
        tvPinyin1.setText(word.getPinyin1());
        tvSentence2.setText(word.getSentence2());
        tvPinyin2.setText(word.getPinyin2());
        tvSentence3.setText(word.getSentence3());
        tvPinyin3.setText(word.getPinyin3());
    }
    private void playAudio(){
        mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse(AUDIO_URL+word.getAudio());
        try {
            mediaPlayer.setDataSource(this,uri);
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
