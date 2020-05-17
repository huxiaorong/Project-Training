package com.example.administrator.leachinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class StudyEndActivity extends AppCompatActivity {
    private Intent intent;
    private SignDate signDate;
    private ImageView imgEnd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_end);
        findView();
        signDate = findViewById(R.id.signDate);

        Glide.with(this)
                .asGif()
                .load(R.drawable.img_end)//图片资源id
                .into(imgEnd);
    }
    public void findView(){
        imgEnd = findViewById(R.id.img_end);
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
