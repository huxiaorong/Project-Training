package com.example.msl.learning_chinese;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LevelOne01Activity extends AppCompatActivity {

    private TextView tvQues;
    private TextView tvGuan;
    private ImageView imgRuturn;
    private CircleProgressbar bar;
    private TextView tvWord;
    private TextView tvPin;
    private TextView tvExplain;
    private LinearLayout ll;
    private TableLayout tableLayout;

    private Word word;
    private String strword;

    private PopupWindow popupWindow = null;
    private View popupView = null;

    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    private OkHttpClient okHttpClient = new OkHttpClient();

    private String likeWord;
    private String[] likeWordArray = null;
    private int[] chooseId = null;

    private int row = 4;
    private int col = 4;
    private int countIndex = 0;

    private Thread thread;

    private final int mis1 = 10000;
    private final int mis2 = 5000;
    private final int mis3 = 3000;

    //增加网格难度
    private final int GUAN_LEVEL1=3;
    private final int GUAN_LEVEL2=6;

    private String tag = "start";

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(final Message msg) {

            switch (msg.what) {
                case 1:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        addTable();
                    }
                    break;
                case 2:

                    new AlertDialog.Builder(LevelOne01Activity.this)
                            .setMessage("时间到")
                            .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent intent3 = new Intent(LevelOne01Activity.this, FindGameActivity.class);
                                    intent3.putExtra("tag", "find");
                                    startActivity(intent3);
                                }
                            })
                            .setNegativeButton("重新挑战", new DialogInterface.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    bar.setProgress(100);
                                    if (Constant.level == 1) {
                                        bar.setTimeMillis(mis1);
                                    } else if (Constant.level == 2) {
                                        bar.setTimeMillis(mis2);
                                    } else if (Constant.level == 3) {
                                        bar.setTimeMillis(mis3);
                                    }

                                    bar.start();

                                    Thread thread1 = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            while (true) {
                                                int pro = bar.getProgress();
                                                if (pro == 0) {
                                                    Message msg = new Message();
                                                    msg.what = 2;
                                                    mainHandle.sendMessage(msg);
                                                    break;
                                                }
                                            }

                                        }
                                    });
                                    thread1.start();
                                }
                            }).setCancelable(false).create().show();
                    break;
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one01);

        //判断是否是FindGame跳转过来的
        String tag1=getIntent().getStringExtra("findToO1");
        if(tag1.equals("findToO1")){
            //1 2关
            if(Constant.guan<GUAN_LEVEL1){
                row=4;
                col=4;
            }
            // 3 4 5关
            else if(Constant.guan>=GUAN_LEVEL1 && Constant.guan<GUAN_LEVEL2){
                row=5;
                col=5;
            }
            //6 7 8 关
            else if(Constant.guan>=GUAN_LEVEL2){
                row=6;
                col=6;
            }

        }else{
            if(getIntent().getIntExtra("row",-1)!=-1){
                row=getIntent().getIntExtra("row",-1);
            }
            if(getIntent().getIntExtra("col",-1)!=-1){
                col=getIntent().getIntExtra("col",-1);
            }
        }


        tvQues = findViewById(R.id.tv_ques);
        tvGuan = findViewById(R.id.tv_guan);
        imgRuturn = findViewById(R.id.img_return);
        tvExplain=findViewById(R.id.tv_phrase);
        ll = findViewById(R.id.ll);

        int resId = getResources().getIdentifier("a"+Constant.level, "drawable", this.getPackageName());        Log.e("关卡","a"+Constant.level);

        if(resId!=0){
            Drawable image = getResources().getDrawable(resId);
            ll.setBackground(image);
        }


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f; //0.0-1.0
                getWindow().setAttributes(lp);
            }
        });

        findLikeWord();


        bar = findViewById(R.id.cp);
        //bar.setProgress(100);
        if (Constant.level == 1) {
            bar.setTimeMillis(mis1);
        } else if (Constant.level == 2) {
            bar.setTimeMillis(mis2);
        } else if (Constant.level == 3) {
            bar.setTimeMillis(mis3);
        }

        bar.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int pro = bar.getProgress();
                    if (pro == 0 && tag.equals("start")) {
                        Message msg = new Message();
                        msg.what = 2;
                        mainHandle.sendMessage(msg);
                        break;
                    }
                }
            }
        });
        thread.start();

        imgRuturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelOne01Activity.this, FindGameActivity.class);
                intent.putExtra("tag", "find");
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addTable() {

        Random r = new Random();
        final int x = r.nextInt(row * col);

        tvGuan.setText("第" + Constant.guan + "关");

        final SpannableStringBuilder style = new SpannableStringBuilder();

        //设置文字
        style.append("请找出“" + likeWordArray[0] + "”字");

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //查询汉字信息
                if (popupWindow == null || !popupWindow.isShowing())
                    showPopupWindow();
            }

            //去掉下划线
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(false);
//                super.updateDrawState(ds);
            }
        };

        style.setSpan(clickableSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvQues.setText(style);

        //设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0000FF"));
        style.setSpan(foregroundColorSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(70);
        style.setSpan(absoluteSizeSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        //设置粗体
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);//粗体
        style.setSpan(styleSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);


        //配置给TextView
        tvQues.setMovementMethod(LinkMovementMethod.getInstance());
        tvQues.setText(style);


        int index = 0;
        tableLayout = findViewById(R.id.table);
        tableLayout.setShrinkAllColumns(true);
        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(LevelOne01Activity.this);
            //tableRow.setBackgroundColor(Color.rgb(255, 255, 255));
            for (int j = 0; j < col; j++) {
                final TextView textView = new TextView(LevelOne01Activity.this);
                textView.setId(countIndex++);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (bar.getProgress() > 0) {

                            Log.e("点击事件", v.getId() + "");
                            if (v.getId() == x) {
                                //Toast.makeText(getApplicationContext(), "回答正确！", Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(LevelOne01Activity.this, LevelOne01Activity.class);
                                Constant.guan++;

                                if(Constant.USER_STATUS!=null){
                                    if(Constant.level==1){
                                        Constant.USER_STATUS.setLevelone(Constant.guan);
                                    }else if(Constant.level==2){
                                      Constant.USER_STATUS.setLeveltwo(Constant.guan);
                                    }else if(Constant.level==3){
                                        Constant.USER_STATUS.setLevelthree(Constant.guan);
                                    }
                                }
                                //1 2关
                                if(Constant.guan<GUAN_LEVEL1){
                                    intent1.putExtra("row",4);
                                    intent1.putExtra("col",4);
                                    intent1.putExtra("findToO1","to");
                                    startActivity(intent1);
                                }
                                // 3 4 5关
                                else if(Constant.guan>=GUAN_LEVEL1 && Constant.guan<GUAN_LEVEL2){
                                    intent1.putExtra("row",5);
                                    intent1.putExtra("col",5);
                                    intent1.putExtra("findToO1","to");
                                    startActivity(intent1);
                                }
                                //6关 及以后
                                else if(Constant.guan>=GUAN_LEVEL2){
                                    intent1.putExtra("row",6);
                                    intent1.putExtra("col",6);
                                    intent1.putExtra("findToO1","to");
                                    startActivity(intent1);
                                }

                            } else {
                                playSoundMusic();
                            }
                        }

                    }
                });

                if (textView.getId() == x) {
                    textView.setText(likeWordArray[0]);
                } else {
                    textView.setText(likeWordArray[1]);
                }

                if(Constant.guan<GUAN_LEVEL1){
                    textView.offsetLeftAndRight(10);
                    textView.setTextSize(35);
                }else if(Constant.guan>=GUAN_LEVEL1 && Constant.guan<GUAN_LEVEL2){
                    textView.setTextSize(30);
                }else if(Constant.guan>=GUAN_LEVEL2){
                    textView.setTextSize(25);
                }

                textView.setBackground(getResources().getDrawable(R.drawable.shaper));
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(FP, WC));
        }

    }


    public void findLikeWord() {

        FormBody body = new FormBody.Builder().add("findlevel", String.valueOf(Constant.level)).build();
        Request request = new Request.Builder()
                .url(Constant.GAME_TWO + "findLikeWord")
                .post(body)
                .build();
        final Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                strword = response.body().string();

                if(!strword.equals("")){
                    Gson gson = new Gson();
                    word = gson.fromJson(strword, Word.class);

                    likeWordArray = word.getLikeword().split("，");

                    Message msg = new Message();
                    msg.what = 1;
                    mainHandle.sendMessage(msg);
                }
            }
        });

    }

    //播放提示音乐
    public void playSoundMusic() {
        SoundPool.Builder builder = null;
        SoundPool sp;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new SoundPool.Builder();
            builder.setMaxStreams(10);
            sp = builder.build();
        } else {
            sp = new SoundPool(10, 5, 5);
        }
        final Map<Integer, Integer> musicId = new HashMap<>();
        musicId.put(1, sp.load(getApplicationContext(), R.raw.x2, 1));
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                //指定播放多个音频流,可以同时播放
                soundPool.play(musicId.get(1), 1, 1, 0, 0, 1);
            }
        });
    }


    // 显示PopupWindow
    private void showPopupWindow() {
        bar.setProgress(bar.getProgress());
        bar.stop();
        tag = "wait";
        // 创建popupWindow对象
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过布局填充器创建View
        popupView = getLayoutInflater()
                .inflate(R.layout.activity_popwindow, null);
        // 设置PopupWindow显示的内容视图
        popupWindow.setContentView(popupView);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否相应点击事件
        popupWindow.setTouchable(true);

        tvWord = popupView.findViewById(R.id.tv_word);
        tvPin = popupView.findViewById(R.id.tv_pin);
        tvExplain = popupView.findViewById(R.id.tv_phrase);
        tvWord.setText(word.getWord());
        tvPin.setText(word.getPinyin());
        tvExplain.setText(word.getExplanation());
        tvWord.setTextSize(30);
        tvPin.setTextSize(25);
        tvPin.setText(PinyinUtil.getPinyinString(word.getWord()));
        TTSUtility ttsUtility = new TTSUtility(this);
        ttsUtility.speaking(word.getWord());
        ImageView ivListen = popupView.findViewById(R.id.iv_listen);
        ivListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TTSUtility ttsUtility = new TTSUtility(getApplicationContext());
                ttsUtility.speaking(word.getExplanation());
            }
        });

        //popupWindow.setBackgroundDrawable(this.getResources().getDrawable(
        //R.mipmap.ic_launcher));// 设置背景图片，不能在布局中设置，要通过代码来设置

        // 在指定控件下方显示PopupWindow
        // popupWindow.showAsDropDown(tvQues, 10, 100);

        //背景变为透明
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.8f; //0.0-1.0
        getWindow().setAttributes(lp);

        //int weight = getWindowManager().getDefaultDisplay().getWidth();

        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(findViewById(R.id.ll), Gravity.BOTTOM, 0, 0);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f; //0.0-1.0
                getWindow().setAttributes(lp);
                tag = "start";
                bar.start();
            }
        });
    }
}


