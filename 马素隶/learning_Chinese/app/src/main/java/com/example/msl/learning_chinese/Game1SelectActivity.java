package com.example.msl.learning_chinese;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Game1SelectActivity extends AppCompatActivity {
    private ImageView ivSimple;
    private ImageView ivMedium;
    private ImageView ivComplex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_select);
        findViews();
        bindListener();
    }
    /**
     * 获取视图
     */
    public void findViews(){
        ivComplex = findViewById(R.id.iv_complex);
        ivMedium = findViewById(R.id.iv_medium);
        ivSimple = findViewById(R.id.iv_simple);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        ivSimple.setOnClickListener(myListener);
        ivMedium.setOnClickListener(myListener);
        ivComplex.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Game1SelectActivity.this,Game1PlayActivity.class);
            switch (v.getId()) {
                case R.id.iv_simple:
                    intent.putExtra("mode","简单");
                    startActivity(intent);
                    break;
                case R.id.iv_complex:
                    intent.putExtra("mode","复杂");
                    startActivity(intent);
                    break;
                case R.id.iv_medium:
                    intent.putExtra("mode","中等");
                    startActivity(intent);
                    break;
            }
        }
    }
}
