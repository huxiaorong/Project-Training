package com.example.msl.learning_chinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Game1BeginActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener{
    private ImageView ivGameBegin;
    private RelativeLayout rl;
    private GestureDetector gd;
    private ImageView ivReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_begin);
        findViews();
        bindListener();
        rl.setOnTouchListener(this);
        rl.setLongClickable(true);
        gd = new GestureDetector(this, this);

    }

    /**
     * 获取视图
     */
    public void findViews(){
        ivGameBegin = findViewById(R.id.iv_begin_game);
        rl = findViewById(R.id.rl_rl);
        ivReturn = findViewById(R.id.img_return);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        ivGameBegin.setOnClickListener(myListener);
        ivReturn.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_begin_game:
                    Intent intent = new Intent(Game1BeginActivity.this,Game1PlayActivity.class);
                    startActivity(intent);
                    break;
                case R.id.img_return:
                    Intent intent1 = new Intent(Game1BeginActivity.this,MainActivity.class);
                    intent1.putExtra("type","quxue");
                    startActivity(intent1);
                    break;
            }
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //手势识别
        //e1:起点信息
        //e2:终点信息
        //velocityX:x方向移动速度
        //velocityY:y方向移动速度
        final int FLING_MIN_DISTANCE = 200;
        final int FLING_MIN_VELOCITY = 200;
        Log.e("e1", e1.getX() + "");
        Log.e("e2", e2.getX() + "");

        //左滑
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Intent intent = new Intent(Game1BeginActivity.this,FindGameActivity.class);
            intent.putExtra("tag","main");
            startActivity(intent);
            overridePendingTransition(R.anim.left_out, R.anim.right_in);
        }
        //右滑
        else if (e1.getX() - e2.getX() < FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            Intent intent = new Intent(Game1BeginActivity.this,FindGameActivity.class);
            intent.putExtra("tag","main");
            startActivity(intent);
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gd.onTouchEvent(event);
    }

}
