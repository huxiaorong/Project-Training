package com.example.msl.learning_chinese;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MyOnGestureListener implements View.OnTouchListener, GestureDetector.OnGestureListener{
    private AppCompatActivity activity;
    private int status;//标记是由哪个fragment
    private Fragment fragment;

    public MyOnGestureListener(AppCompatActivity activity,int status,Fragment fragment) {
        this.activity = activity;
        this.status = status;
        this.fragment = fragment;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
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
            if (status == 1) {
                FragmentTransaction transaction =
                        activity.getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("tag", "main");
                Game2Fragment game2Fragment = new Game2Fragment();
                game2Fragment.setArguments(bundle);
                transaction.hide(fragment);
                activity.overridePendingTransition(R.anim.left_out, R.anim.right_in);
                transaction.add(R.id.tab_content,game2Fragment).commit();
            }
            else {
                FragmentTransaction transaction =
                        activity.getSupportFragmentManager().beginTransaction();
                transaction.hide(fragment);
                transaction.add(R.id.tab_content,new GamesFragment()).commit();
                activity.overridePendingTransition(R.anim.left_out, R.anim.right_in);
            }

        }
        //右滑
        else if (e1.getX() - e2.getX() < FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            if (status == 1) {
                FragmentTransaction transaction =
                        activity.getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("tag", "main");
                Game2Fragment game2Fragment = new Game2Fragment();
                game2Fragment.setArguments(bundle);
                transaction.hide(fragment);
                transaction.add(R.id.tab_content,game2Fragment).commit();
            }
            else {
                FragmentTransaction transaction =
                        activity.getSupportFragmentManager().beginTransaction();
                transaction.hide(fragment);
                transaction.add(R.id.tab_content,new GamesFragment()).commit();
            }
            activity.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
