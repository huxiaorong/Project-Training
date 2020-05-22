package com.example.msl.learning_chinese;

import android.annotation.SuppressLint;
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

import com.ant.liao.GifView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class GamesFragment extends Fragment{
    private Button btnFindGame;
    private Button btnGame1;
    private GifView mGif;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab_game,
                container, false);
        findViews(view);
        bindListener();
        gifView();
        return view;
    }

    /**
     * 获取视图
     */
    public void findViews(View view){
        btnFindGame = view.findViewById(R.id.btn_findGame);
        btnGame1 = view.findViewById(R.id.btn_game1);
        mGif = view.findViewById(R.id.gv_mgift);
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
    /**
     * GifView获取图片资源
     */
    private void gifView(){
        try {
            @SuppressLint("ResourceType") InputStream is = this.getResources().openRawResource(R.drawable.bear);//获取动图资源
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int len = 0;
            while ((len = is.read(b, 0, 2048)) != -1) {
                baos.write(b, 0, len);
            }
            baos.flush();//刷新流，确保传递完全
            byte[] bytes = baos.toByteArray();//转换成Byte数组
            mGif.setGifImage(bytes);
            // 添加监听器
            //gif.setOnClickListener(this);
            // 设置显示的大小，拉伸或者压缩,由于GiftView在布局文件中设置宽和高无效，所以要设置宽和高
            mGif.setShowDimension(300, 300);
            // 设置加载方式：先加载后显示、边加载边显示、只显示第一帧再显示
            mGif.setGifImageType(GifView.GifImageType.WAIT_FINISH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
