package com.example.msl.learning_chinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelOneStarActivity extends AppCompatActivity {
    private Intent intent;
    private Intent intentReturn;
    private TextView tvLevel;
    private ImageView imgReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_star);
        intent=new Intent(LevelOneStarActivity.this,LevelOne01Activity.class);
        tvLevel=findViewById(R.id.tv_level);

        tvLevel.setText(Constant.level+"级");

        imgReturn=findViewById(R.id.img_return);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentReturn=new Intent(LevelOneStarActivity.this,LevelOne01Activity.class);
                startActivity(intentReturn);
            }
        });
    }

    public void chooseClicked(View view) {
        switch (view.getId()){
            case R.id.tv_guan1:
                Constant.guan=1;
                startActivity(intent);
                break;
            case R.id.tv_guan2:
                Constant.guan=2;
                startActivity(intent);
                break;
            case R.id.tv_guan3:
                Constant.guan=3;
                startActivity(intent);
                break;
            case R.id.tv_guan4:
                break;
            case R.id.tv_guan5:
                break;
            case R.id.tv_guan6:
                break;
            case R.id.tv_guan7:
                break;
            case R.id.tv_guan8:
                break;
            case R.id.tv_guan9:
                break;
        }
    }
}
