package cn.edu.hebtu.software.learnchinese;

import android.content.Intent;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class FindGameActivity extends AppCompatActivity {

    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_game);

        btnStart=findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindGameActivity.this,LevelChooseActivity.class);
                startActivity(intent);
            }
        });
        playSoundMusic();
    }
    //播放音乐
    public void playSoundMusic(){
        SoundPool.Builder builder= null;
        SoundPool sp;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            builder = new SoundPool.Builder();
            builder.setMaxStreams(10);
            sp=builder.build();
        }else{
            sp=new SoundPool(10,5,5);
        }
        final Map<Integer,Integer> musicId=new HashMap<>();
        musicId.put(1,sp.load(getApplicationContext(),R.raw.x1,1));
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                //指定播放多个音频流,可以同时播放
                soundPool.play(musicId.get(1), 1, 1, 0, 0, 1);
            }
        });
    }
}
