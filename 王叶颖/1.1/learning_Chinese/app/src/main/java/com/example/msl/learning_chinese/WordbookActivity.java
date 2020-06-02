package com.example.msl.learning_chinese;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;

public class WordbookActivity extends AppCompatActivity {
    private ListView lvWords;
    private ImageView imgBack;
    private TextView tvStudied;
    private TextView tvWillStudy;
    private OkHttpClient okHttpClient;
    private List<Word> learnedList;
    private List<Word> notLearnedList;
    private List<Word> bookList;
    private TextView tvLeft;
    private TextView tvRight;
    private Gson gson;
    private WordBookAdapter wordBookAdapter;
    private boolean curChoose = true;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordbook);
        findView();
        Intent intent = getIntent();
        String str1 = intent.getStringExtra("learnedList");
        String str2 = intent.getStringExtra("notLearnedList");
        learnedList = gson.fromJson(str1,new TypeToken<List<Word>>(){}.getType());
        notLearnedList = gson.fromJson(str2,new TypeToken<List<Word>>(){}.getType());
        Log.e("learnedList","str1"+str1);
        Log.e("learnedListSize",notLearnedList.size()+"");
        Log.e("notLearnedList","str2"+str2);
        Log.e("notLearnedListSize",notLearnedList.size()+"");
        bookList = learnedList;
        init();
    }
    private void init(){
        wordBookAdapter = new WordBookAdapter(bookList, R.layout.item_word_list,this);
        lvWords.setAdapter(wordBookAdapter);

    }
    private void findView(){
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        imgBack=findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WordbookActivity.this.finish();
            }
        });
        tvStudied = findViewById(R.id.tv_studied);
        tvStudied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!curChoose){
                    curChoose = true;
                    tvLeft.setBackgroundColor(Color.parseColor("#1ABFB2"));
                    tvRight.setBackgroundColor(Color.parseColor("#ffffff"));
                    bookList = learnedList;
                    init();
                }
            }
        });
        tvWillStudy = findViewById(R.id.tv_willstudy);
        tvWillStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curChoose){
                    curChoose = false;
                    tvLeft.setBackgroundColor(Color.parseColor("#ffffff"));
                    tvRight.setBackgroundColor(Color.parseColor("#1ABFB2"));
                    bookList = notLearnedList;
                    init();
                }
            }
        });
        lvWords = findViewById(R.id.lv_words);
        tvLeft = findViewById(R.id.tv_line_learned);
        tvRight = findViewById(R.id.tv_line_not_learned);
        lvWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(WordbookActivity.this,WordItemActivity.class);
                intent.putExtra("word",gson.toJson(bookList.get(position)));
                startActivity(intent);
            }
        });
    }

}
