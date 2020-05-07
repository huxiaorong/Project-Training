package com.example.administrator.leachinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class StudyEndActivity extends AppCompatActivity {
    private Intent intent;
    private SignDate signDate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_end);
        signDate = findViewById(R.id.signDate);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            StudyEndActivity.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
