package com.example.msl.learning_chinese;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WordItemActivity extends AppCompatActivity {
//    private TextView tvWord;
    private TextView tvPinyin;
    private TextView tvExplanation;
    private YXLTextView tvSentence1;
//    private TextView tvPinyin1;
    private YXLTextView tvSentence2;
//    private TextView tvPinyin2;
    private YXLTextView tvSentence3;
//    private TextView tvPinyin3;
    private ImageView imgPlay;
    private ImageView imgCollection;
    private Gson gson;
    private Intent intent;
    private Word word;
    MediaPlayer mediaPlayer;
    private OkHttpClient okHttpClient;
    private int isCollection = 0;
    private WebView webView;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_item);
        findView();
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        intent = getIntent();
        String intentStr = intent.getStringExtra("word");

        word = gson.fromJson(intentStr,Word.class);
        collectOrNot();
        initDate();
        playAudio();
    }
    private void findView() {
//        tvWord = findViewById(R.id.tv_word);
        tvPinyin = findViewById(R.id.tv_pinyin);

        tvExplanation = findViewById(R.id.tv_explanation);
        tvSentence1 = findViewById(R.id.tv_sentence1);
//        tvPinyin1 = findViewById(R.id.tv_pinyin1);
        tvSentence2 = findViewById(R.id.tv_sentence2);
//        tvPinyin2 = findViewById(R.id.tv_pinyin2);
        tvSentence3 = findViewById(R.id.tv_sentence3);
//        tvPinyin3 = findViewById(R.id.tv_pinyin3);
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
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/test.html");
        //启用支持javascript

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());

        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WordItemActivity.this.finish();
            }
        });
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView webView, String url) {
            webView.loadUrl("javascript:bishun(" + "'"+word.getWord()+"'" + ")");
        }
    }
    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onConsoleMessage(ConsoleMessage cm) {
            Log.d("test", cm.message() + " -- From line "
                    + cm.lineNumber() + " of "
                    + cm.sourceId() );
            return true;
        }
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Toast.makeText(WordItemActivity.this, message, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
    private void initDate() {
//        tvWord.setText(word.getWord());
//        tvPinyin.setText(word.getPinyin());
        tvPinyin.setText(PinyinUtil.getPinyinString(word.getWord()));
        tvExplanation.setText(word.getExplanation());
        tvSentence1.setMyText(word.getSentence1());
//        tvPinyin1.setText(word.getPinyin1());
        tvSentence2.setMyText(word.getSentence2());
//        tvPinyin2.setText(word.getPinyin2());
        tvSentence3.setMyText(word.getSentence3());
//        tvPinyin3.setText(word.getPinyin3());
    }
    private void playAudio() {
        mediaPlayer = new MediaPlayer();
        Uri uri = Uri.parse(Constant.AUDIO_URL + word.getAudio());
        try {
            mediaPlayer.setDataSource(this, uri);
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    加入收藏夹
    */
    private void addCollection() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/add/collection?userId=" + Constant.USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                .url(Constant.BASE_URL + "user/judge/collection?userId=" + Constant.USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
                .url(Constant.BASE_URL + "user/delete/collection?userId=" + Constant.USER_STATUS.getId() + "&wordId=" + word.getId())//设置网络请求的URL地址
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
