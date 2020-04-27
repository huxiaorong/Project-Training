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
    }

}
