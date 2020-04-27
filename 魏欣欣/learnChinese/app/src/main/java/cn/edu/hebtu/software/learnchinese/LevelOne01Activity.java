package cn.edu.hebtu.software.learnchinese;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import com.dinuscxj.progressbar.CircleProgressBar;

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

    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    private OkHttpClient okHttpClient = new OkHttpClient();

    private String likeWord;
    private String[] likeWordArray = null;
    private int[] chooseId = null;

    private int row = 4;
    private int col = 4;
    private int countIndex = 0;
    private int wordCount = 0;

    private MediaPlayer mediaPlayer;

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(final Message msg) {

            switch (msg.what) {
                case 1:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        addTable();
                    }

                    break;
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one01);

        tvQues = findViewById(R.id.tv_ques);
        tvGuan = findViewById(R.id.tv_guan);
        imgRuturn = findViewById(R.id.img_return);

        findLikeWord();
        //playBackSound();

        bar = findViewById(R.id.cp);
        //bar.setProgress(100);
        bar.setTimeMillis(2000);
        bar.start();

        imgRuturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;
                }*/
                Intent intent = new Intent(LevelOne01Activity.this, LevelOneStarActivity.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addTable() {
        Random r = new Random();
        final int x = r.nextInt(row*col);

        tvQues.setText("请找出“" + likeWordArray[0] + "”字");
        tvGuan.setText("第" + Constant.guan + "关");
        int index = 0;
        TableLayout tableLayout = findViewById(R.id.table);
        tableLayout.setShrinkAllColumns(true);
        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(LevelOne01Activity.this);
            tableRow.setBackgroundColor(Color.rgb(255, 255, 255));
            for (int j = 0; j < col; j++) {
                final TextView textView = new TextView(LevelOne01Activity.this);
                textView.setId(countIndex++);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("点击事件", v.getId() + "");
                        if(v.getId()==x){
                            Toast.makeText(getApplicationContext(), "回答正确！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                if(textView.getId()==x){
                    textView.setText(likeWordArray[0]);
                }else{
                    textView.setText(likeWordArray[1]);
                }
                /*Log.e("x", x + "");
                if (x == 0) {
                    wordCount = wordCount + 1;
                    if (wordCount == 1) {
                        textView.setText(likeWordArray[x]);
                    } else {
                        x = x + 1;
                        textView.setText(likeWordArray[x]);
                    }
                } else {
                    textView.setText(likeWordArray[x]);
                }*/


                textView.setTextSize(40);
                textView.setBackground(getResources().getDrawable(R.drawable.shaper));
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(FP, WC));
        }
    }

    public void findLikeWord() {

        FormBody body = new FormBody.Builder().add("findlevel", String.valueOf(Constant.level)).build();
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "findLikeWord")
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
                likeWord = response.body().string();
                likeWordArray = likeWord.split("，");

                Message msg = new Message();
                msg.what = 1;
                mainHandle.sendMessage(msg);
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                int nowGuan = Constant.guan;
                Constant.guan = nowGuan + 1;
                Intent intent = new Intent(LevelOne01Activity.this, LevelOne01Activity.class);
                startActivity(intent);
                break;

        }
    }

    //播放音乐
    public void playSoundMusic() {
        SoundPool.Builder builder = null;
        SoundPool sp;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            builder = new SoundPool.Builder();
            builder.setMaxStreams(10);
            sp = builder.build();
        } else {
            sp = new SoundPool(10, 5, 5);
        }
        final Map<Integer, Integer> musicId = new HashMap<>();
        musicId.put(1, sp.load(getApplicationContext(), R.raw.yekong, 1));
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                //指定播放多个音频流,可以同时播放
                soundPool.play(musicId.get(1), 1, 1, 0, 0, 1);
            }
        });
    }

    public void playBackSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.yekong);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        Log.e("destory","de");
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();//停止音频的播放
        }
        mediaPlayer.release();//释放资源
        super.onDestroy();
    }
}
