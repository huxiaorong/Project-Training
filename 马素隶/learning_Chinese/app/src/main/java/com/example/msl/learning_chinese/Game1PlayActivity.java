package com.example.msl.learning_chinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Game1PlayActivity extends AppCompatActivity {
    private TextView tvMode;
    private ImageView ivLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_play_acitivity);
        findViews();
        bindListener();
        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");
        tvMode.setText(mode);
    }
    /**
     * 获取视图
     */
    public void findViews(){
        tvMode = findViewById(R.id.tv_mode);
        ivLeft = findViewById(R.id.iv_left);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        ivLeft.setOnClickListener(myListener);
        tvMode.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_left:
                    finish();
                    break;
            }
        }
    }
}
