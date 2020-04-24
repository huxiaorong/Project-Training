package com.example.administrator.leachinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.example.administrator.leachinese.Constant.USER_STATUS;

public class MainActivity extends AppCompatActivity {
    private ImageView imgHead;
    private TextView tvCur;
    private TextView tvGoal;
    private Button btnStart;
    private Button btnChangeBooks;
    private OkHttpClient okHttpClient;
    private Gson gson;
    private List<Word> wordList;
    private List<Level> books;
    private Intent intent;
    private int pageNum;
    private int wordNum;
    private long exitTime = 0;
    private List<Record> records;
    private String bookstr;
    private TextView tvBook;
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
        if((bookstr = getIntent().getStringExtra("levelBook"))!=null){
            tvBook.setText(bookstr);
        }
        //头像设置
        RequestOptions options = new RequestOptions()
                .circleCrop();//圆形剪裁
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.head)//图片资源id
                .into(imgHead);
        tvCur.setText(""+wordNum);
        getWordList();
        getBooksList();
        findToday();

    }

    private void findViews() {
        imgHead = findViewById(R.id.img_head);
        tvCur = findViewById(R.id.tv_cur);
        tvGoal = findViewById(R.id.tv_goal);
        tvBook = findViewById(R.id.tv_book);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wordList.size()<=wordNum){
                    Constant.USER_STATUS.setStudiedTag(pageNum+1);
                    Constant.USER_STATUS.setNumberTag(0);
                    pageNum = pageNum+1;
                    wordNum = 0;
                    updateProgress();
                    reWordList();
                }
                intent = new Intent(v.getContext(),StudyActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
        btnChangeBooks = findViewById(R.id.btn_changebooks);
        btnChangeBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), SelectLevelBooksActivity.class);
                Log.e("books", books.toString());
                intent.putExtra("books",gson.toJson(books));
                intent.putExtra("book",tvBook.getText());
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            doubleClickExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
    private void doubleClickExit() {
        // System.currentTimeMillis()无论何时调用，肯定大于2000
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次返回键返回到桌面",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
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
                        tvCur.setText(""+wordNum);
                    }
                });

            }
        });
    }
    /*
    重新今日单词列表
    */
    private void reWordList() {
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
                intent = new Intent(MainActivity.this,StudyActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
    /*
    获取今日学习记录
    */
    private void findToday() {
        Log.e("request", "start");
        //2.创建Request对象
        final Request request = new Request.Builder()
                .url(Constant.BASE_URL + "record/find/today?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
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
                records = gson.fromJson(reStr, new TypeToken<List<Record>>() {
                }.getType());
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (wordNum>=wordList.size()){
                            if (records.size()!=0){
                                btnStart.setText("再学一次");
                            }else{
                                Constant.USER_STATUS.setStudiedTag(pageNum+1);
                                Constant.USER_STATUS.setNumberTag(0);
                                pageNum = pageNum+1;
                                wordNum = 0;
                                updateProgress();
                            }
                        }else{

                        }
                    }
                });

            }
        });
    }
    /*
    更新用户进度
    */
    private void updateProgress() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/update/progress?userId=" + USER_STATUS.getId()+"&studiedTag=" + pageNum+"&numberTag="+wordNum)//设置网络请求的URL地址
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
    获取年级等级书目
     */
    private void getBooksList(){
        Log.e("requestBooks","start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "level/list")//设置网络请求的URL地址
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

                books = gson.fromJson(reStr, new TypeToken<List<Level>>() {
                }.getType());

            }
        });
    }
}
