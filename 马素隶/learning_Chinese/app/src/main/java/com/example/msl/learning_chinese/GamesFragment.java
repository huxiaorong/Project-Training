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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class GamesFragment extends Fragment{
    private Button btnFindGame;
    private Button btnGame1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_game,
                container, false);
        findViews(view);
        bindListener();

        return view;
    }

    /**
     * 获取视图
     */
    public void findViews(View view){
        btnFindGame = view.findViewById(R.id.btn_findGame);
        btnGame1 = view.findViewById(R.id.btn_game1);
    }

    /**
     * 绑定点击事件
     */
    private void bindListener(){
        MyListener myListener = new MyListener();
        btnGame1.setOnClickListener(myListener);
        btnFindGame.setOnClickListener(myListener);

    }

    /**
     * 点击事件的实现
     */
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_findGame:
                    Intent intent = new Intent(getActivity(),FindGameActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_game1:
                    Intent intent1 = new Intent(getActivity(),Game1BeginActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    }
}
