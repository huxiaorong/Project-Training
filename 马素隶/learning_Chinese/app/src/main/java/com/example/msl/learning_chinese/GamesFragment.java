package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class GamesFragment extends Fragment{
    private ImageView ivGameBegin;
    private RelativeLayout rl;
    private GestureDetector gd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_game1_begin,
                container, false);
        findViews(view);
        bindListener();
        rl.setLongClickable(true);
        gd = new GestureDetector(getActivity(), new MyOnGestureListener((AppCompatActivity) getActivity(),1,this));
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gd.onTouchEvent(event);
            }
        });
        return view;
    }

    /**
     * 获取视图
     */
    public void findViews(View view){
        ivGameBegin = view.findViewById(R.id.iv_begin_game);
        rl = view.findViewById(R.id.rl_rl);
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
                    Intent intent = new Intent(getActivity(),Game1PlayActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
