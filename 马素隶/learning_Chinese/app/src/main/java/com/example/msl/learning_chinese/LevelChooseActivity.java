package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class LevelChooseActivity extends Activity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choose);
        intent=new Intent(LevelChooseActivity.this,LevelOne01Activity.class);
    }

    public void onClickLevel(View view) {
        switch (view.getId()){
            case R.id.level_1:
                Constant.level=1;
                startActivity(intent);
                break;
            case R.id.level_2:
                Constant.level=2;
                startActivity(intent);
                break;
        }
    }
}
