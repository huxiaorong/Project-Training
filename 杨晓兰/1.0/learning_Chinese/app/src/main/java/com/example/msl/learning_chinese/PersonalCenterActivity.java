package com.example.msl.learning_chinese;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.mob.MobSDK.getContext;

//import static java.security.AccessController.getContext;


public class PersonalCenterActivity extends BaseActivity {
    private boolean mIsNightMode;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Count count;
    private TextView tvPraiseFragment;
    private TextView tvCollectionFragment;
    private TextView tvNotesFragment;
    private ImageView ivSettings;
    private Button btnEdit;
    private ImageView ivHeader;
    private TextView tvPraise;
//    private TextView tvCollection;
    private TextView tvNotes;
    private String rsp;
    private ImageView imageView1;//头像图片
    private TextView textView1; //昵称
    private ImageView imageView2;//向前图标
    private TextView textView2;//坚持天数
    private TextView textView3;//学习总量
//    private LinearLayout linearLayout1;//我的计划
    private LinearLayout linearLayout2;//我的收藏
    private LinearLayout linearLayout3;//错题本
    private LinearLayout linearLayout4;//设置
    private LinearLayout linearLayout5;//夜间模式
    private Button button;

    private ImageView ivLeft;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_personal_center, container, false);
        findView();
        bindListener();



        if (Constant.USER_STATUS.getImg() != null) {
            Glide.with(getContext())
                    .load(Constant.BASE_URL + "headPicture/" + Constant.USER_STATUS.getImg())
                    .into(ivHeader);
        }

        return view;
    }

    public void findView(){
        imageView1=findViewById(R.id.headPicture);
        textView1=findViewById(R.id.nickName);
        imageView2=findViewById(R.id.ahead);
        textView2=findViewById(R.id.totalDays);
        textView3=findViewById(R.id.totalNumber);
//        linearLayout1=findViewById(R.id.myPlane);
        linearLayout2=findViewById(R.id.myLike);
        linearLayout3=findViewById(R.id.myMistake);
        linearLayout4=findViewById(R.id.mySetting);
        linearLayout5=findViewById(R.id.inDarken);
        ivLeft = findViewById(R.id.houtui_01);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCount();


    }


    private void bindListener(){
        MyListener myListener = new MyListener();
        tvNotesFragment.setOnClickListener(myListener);
        tvCollectionFragment.setOnClickListener(myListener);
        tvPraiseFragment.setOnClickListener(myListener);
        ivSettings.setOnClickListener(myListener);
        btnEdit.setOnClickListener(myListener);
    }
    private class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ahead:
                    Intent intent=new Intent(PersonalCenterActivity.this,EditActivity.class);
                    startActivity(intent);
                case R.id.totalDays:
                    textView2.setText(count.getDaysNumber());
                    break;
                case R.id.totalNumber:
                    textView3.setText(count.getStudyNumber());
                    break;
                case R.id.myLike:
                    Intent intent1 = new Intent(PersonalCenterActivity.this, LikeFragment.class);
                    startActivity(intent1);
                    break;
                case R.id.myMistake:
                    Intent intent2 = new Intent(PersonalCenterActivity.this, MyMistakeFragment.class);
                    startActivity(intent2);
                    break;
                case R.id.mySetting:
                    Intent intent3 = new Intent(PersonalCenterActivity.this, EditActivity.class);
                    startActivity(intent3);
                    break;
//                case R.id.inDarken:
//                    mIsNightMode = getApp().isNightMode();
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            // TODO Auto-generated method stub
//                            changeViewMode();
//                        }
//                    });
                case R.id.houtui_01:
                    finish();
                    break;
            }
        }


    }
    private void getCount(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "center/getCount?userId="+Constant.USER_STATUS.getId())//设置网络请求的地址
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                rsp = response.body().string();
                Log.e("rrr", rsp);
//                Message msg = new Message();
////                msg.what = 1;
////                mainHandle.sendMessage(msg);
                runOnUiThread(new Runnable() {
                    public void run() {
                        Count count = new Gson().fromJson(rsp,Count.class);
                        textView2.setText(count.getDaysNumber()+"");
                        textView3.setText(count.getStudyNumber()+"");

                        if (Constant.USER_STATUS.getImg() != null) {
                            //RequestOptions options = new RequestOptions().circleCrop();
                            Glide.with(getContext())
                                    .load(Constant.BASE_URL + "headPicture/" + Constant.USER_STATUS.getImg())
                                    .into(ivHeader);
                        }
                    }
                });

            }
        });
    }







//        @Override
//
//        protected void onResume() {
//
//            super.onResume();
//
//            if (mIsNightMode != getApp().isNightMode()) {
//
//                recreateOnResume();
//
//            }
//
//        }



//        void changeViewMode() {
//
//            boolean isNight = getApp().isNightMode();
//
//            if (isNight) {
//
//                ChangeToDay();
//
//            } else {
//
//                ChangeToNight();
//
//            }
//
//            recreate();
//
//        }



}
