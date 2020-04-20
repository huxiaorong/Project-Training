package com.example.msl.learning_chinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Game1BeginActivity extends AppCompatActivity {
    private ImageView ivGameBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_begin);
        findViews();
        bindListener();
    }

    /**
     * 获取视图
     */
    public void findViews(){
        ivGameBegin = findViewById(R.id.iv_begin_game);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        ivGameBegin.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_begin_game:
                    Intent intent = new Intent(Game1BeginActivity.this,Game1SelectActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
