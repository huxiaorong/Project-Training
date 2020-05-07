package com.example.administrator.leachinese;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private OkHttpClient okHttpClient;
    private int isCollection = 0;
    private TextView tvTips;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);
        findView();
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        intent = getIntent();
        String intentStr = intent.getStringExtra("wordList");
        Log.e("WordDetailsActivity", intentStr);
        wordList = gson.fromJson(intentStr, new TypeToken<List<Word>>() {
        }.getType());
        word = wordList.get(Constant.USER_STATUS.getNumberTag());
        collectOrNot();
        initDate();
        playAudio();
        prompt();
    }



    private void findView() {
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
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();//暂停播放
                } else {
                    mediaPlayer.start();
                }
            }
        });
        imgCollection = findViewById(R.id.img_collection);
        imgCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollection == 0){
                    addCollection();
                    imgCollection.setImageDrawable(getResources().getDrawable(R.drawable.aftercollect));
                    isCollection = 1;
                }else{
                    deleteCollection();
                    imgCollection.setImageDrawable(getResources().getDrawable(R.drawable.beforecollect));
                    isCollection = 0;
                }

            }
        });
        btnKnow = findViewById(R.id.btn_know);
        btnKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_STATUS.setNumberTag(USER_STATUS.getNumberTag() + 1);
                updateNumProgress();
                if (USER_STATUS.getNumberTag() < wordList.size()) {
                    intent = new Intent(v.getContext(), StudyActivity.class);
                    intent.putExtra("wordList", gson.toJson(wordList));
                    startActivity(intent);
                    WordDetailsActivity.this.finish();
                } else {
                    recordTime();
                    intent = new Intent(v.getContext(), StudyEndActivity.class);
                    startActivity(intent);
                    WordDetailsActivity.this.finish();
                }
            }
        });
        btnNo = findViewById(R.id.btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_STATUS.setNumberTag(USER_STATUS.getNumberTag() + 1);
                updateNumProgress();
                addWrongWord();
                if (USER_STATUS.getNumberTag() < wordList.size()) {
                    intent = new Intent(v.getContext(), StudyActivity.class);
                    intent.putExtra("wordList", gson.toJson(wordList));
                    startActivity(intent);
                    WordDetailsActivity.this.finish();
                } else {
                    recordTime();
                    intent = new Intent(v.getContext(), StudyEndActivity.class);
                    startActivity(intent);
                    WordDetailsActivity.this.finish();
                }
            }
        });
        tvTips = findViewById(R.id.tv_tips);
    }

    private void initDate() {
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

    private void prompt() {
        int complete = USER_STATUS.getNumberTag();
        int left = wordList.size() - complete;
        tvTips.setText("已学 "+complete+"个，还剩 "+left+"个");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 创建一个AlertDialog构造器，构造者
            AlertDialog.Builder adBuilder = new AlertDialog
                    .Builder(WordDetailsActivity.this);
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
                            intent = new Intent(WordDetailsActivity.this, MainActivity.class);
                            startActivity(intent);
                            WordDetailsActivity.this.finish();
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

    private void playAudio() {
        mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse(AUDIO_URL + word.getAudio());
        try {
            mediaPlayer.setDataSource(this, uri);
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    更新用户进度
    */
    private void updateNumProgress() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/update/num?userId=" + USER_STATUS.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
            }
        });
    }

    /*
    记录学习时间
    */
    private void recordTime() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "record/add?userId=" + USER_STATUS.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
            }
        });
    }

    /*
    加入错题本
    */
    private void addWrongWord() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/add/wrong?userId=" + USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
            }
        });
    }

    /*
    加入收藏夹
    */
    private void addCollection() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/add/collection?userId=" + USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
            }
        });
    }

    /*
    查询用户是否收藏该单词
     */
    private void collectOrNot() {
        Log.e("requestSelect", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/judge/collection?userId=" + USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String str = response.body().string();
                Log.e("异步GET请求结果", str);
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (str.equals("true")) {
                            isCollection = 1;
                            imgCollection.setImageDrawable(getResources().getDrawable(R.drawable.aftercollect));

                        } else {
                            isCollection = 0;
                            imgCollection.setImageDrawable(getResources().getDrawable(R.drawable.beforecollect));

                        }
                    }
                });
            }
        });
    }
    /*
    删除收藏
     */
    private void deleteCollection() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/delete/collection?userId=" + USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
            }

        });
    }
}
