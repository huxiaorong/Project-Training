package com.example.msl.learning_chinese;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FindGameActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener{

    private ImageView start;
    private ImageView open;
    private ImageView back;
    private Spinner spinner;
    private RelativeLayout rl;
    private GestureDetector gd;

    private MediaPlayer mediaPlayer;
    private OkHttpClient okHttpClient = new OkHttpClient();

    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);

        setIntent(intent);
        processExtraData();
    }
    private void processExtraData(){

        if(getIntent().getStringExtra("tag").equals("main")){
            open.setTag("open");
            open.setImageResource(R.drawable.open);
            mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.backmusic);
            mediaPlayer.start();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_game);

        rl = findViewById(R.id.rl_rl);
        rl.setOnTouchListener(this);
        rl.setLongClickable(true);
        gd = new GestureDetector(this, this);

        start = findViewById(R.id.btn_start);
        open = findViewById(R.id.open);
        back = findViewById(R.id.img_return);
        spinner=findViewById(R.id.spinner);
        setSpinner();

        open.setTag("open");
        mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.backmusic);
        mediaPlayer.start();
        click();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setSpinner(){

        String[] curs = getResources().getStringArray(R.array.level);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.personal_spinner, curs);
        //此处修改的部分为 点击后弹出的选择框，同上可引用自己写的布局文件，也可以使用默认布局，此处使用的是默认布局
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,name);

        adapter.setDropDownViewResource(R.layout.dropdown_stytle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            spinner.setBackground(getDrawable(R.drawable.drop));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            spinner.setPopupBackgroundDrawable(getDrawable(R.drawable.drop));
        }

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //点击处理事件
                Constant.level=position+1;

                if(Constant.USER_STATUS.getId()==0||Constant.USER_STATUS==null){
                    Constant.guan=1;
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void click() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindGameActivity.this, LevelOne01Activity.class);
                if(Constant.USER_STATUS.getId()!=0&&Constant.USER_STATUS!=null){
                    if(Constant.level==1){
                        Constant.guan=Constant.USER_STATUS.getLevelone();
                    }else if(Constant.level==2){
                        Constant.guan=Constant.USER_STATUS.getLeveltwo();
                    }else if(Constant.level==3){
                        Constant.guan=Constant.USER_STATUS.getLevelthree();
                    }
                }
                intent.putExtra("findToO1","findToO1");
                startActivity(intent);
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (open.getTag().equals("open")) {
                    //关闭音乐
                    if (mediaPlayer.isPlaying()) {//判断当前是否在播放
                        mediaPlayer.pause();
                       /* try {
                            mediaPlayer.prepare();//准备下一次播放
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                    }
                    //mediaPlayer.stop();
                    open.setTag("close");
                    open.setImageResource(R.drawable.close);
                } else {
                    //播放音乐
                    mediaPlayer.start();
                    open.setTag("open");
                    open.setImageResource(R.drawable.open);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveUserLevelGuan(Constant.USER_STATUS);
                Intent intent = new Intent(FindGameActivity.this,MainActivity.class);
                intent.putExtra("type","quxue");
                startActivity(intent);
                mediaPlayer.stop();
            }
        });
    }

    private void saveUserLevelGuan(User user) {
        Gson gson=new Gson();
        String strUser =gson.toJson(Constant.USER_STATUS);
        FormBody body = new FormBody.Builder().add("strUser", strUser).build();
        Request request = new Request.Builder()
                .url(Constant.GAME_TWO + "save")
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
                Log.e("message","successful");
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //手势识别
        //e1:起点信息
        //e2:终点信息
        //velocityX:x方向移动速度
        //velocityY:y方向移动速度
        final int FLING_MIN_DISTANCE = 200;
        final int FLING_MIN_VELOCITY = 200;
        Log.e("e1", e1.getX() + "");
        Log.e("e2", e2.getX() + "");

        //左滑
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Intent intent = new Intent(FindGameActivity.this,Game1BeginActivity.class);
            startActivity(intent);
            mediaPlayer.stop();
            overridePendingTransition(R.anim.left_out, R.anim.right_in);

        }
        //右滑
        else if (e1.getX() - e2.getX() < FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Intent intent = new Intent(FindGameActivity.this,Game1BeginActivity.class);
            startActivity(intent);
            mediaPlayer.stop();
            overridePendingTransition(R.anim.left_in, R.anim.right_out);

        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gd.onTouchEvent(event);
    }


}
