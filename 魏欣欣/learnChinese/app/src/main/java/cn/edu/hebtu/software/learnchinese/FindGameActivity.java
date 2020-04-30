package cn.edu.hebtu.software.learnchinese;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


public class FindGameActivity extends AppCompatActivity {

    private ImageView start;
    private ImageView open;
    private ImageView back;
    private Spinner spinner;

    private MediaPlayer mediaPlayer;

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

    public void setSpinner(){

        String[] curs = getResources().getStringArray(R.array.level);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.personal_spinner, curs);
        //此处修改的部分为 点击后弹出的选择框，同上可引用自己写的布局文件，也可以使用默认布局，此处使用的是默认布局
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //adapter = new ArrayAdapter<String>(this,R.layout.spinner_item,name);

        adapter.setDropDownViewResource(R.layout.dropdown_stytle);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //点击处理事件
                Constant.level=position+1;

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
                Intent intent = new Intent(FindGameActivity.this, MainActivity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });
    }



}
