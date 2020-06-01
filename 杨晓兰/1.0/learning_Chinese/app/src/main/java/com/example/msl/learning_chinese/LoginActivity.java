package com.example.msl.learning_chinese;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etPhoneNum;
    private EditText etPwd;
    private ImageView imageView;
    private TextView tvNumLogin;
    private TextView tvForget;
    private Button btnLogin;
    private String rsp;
    private String phone;
    private ImageView ivLeft;
    private SharedPreferences sharedPreferences;
    private String QQphone;

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (!(rsp.equals("登录失败"))) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, PersonalCenterActivity.class);
                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                        Constant.USER_STATUS = gson.fromJson(rsp,User.class);
                        Log.e("user",Constant.USER_STATUS.toString());
                        //写入sharedpreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user",gson.toJson(Constant.USER_STATUS));
                        editor.commit();
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, rsp, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 2:
                    if (!(rsp.equals("登录失败"))) {
                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                        Constant.USER_STATUS = gson.fromJson(rsp,User.class);
                        if (Constant.USER_STATUS.getTel()==null) {
                            //注册手机号
                            sendCode2(LoginActivity.this);
                        }else{
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Constant.USER_STATUS = gson.fromJson(rsp,User.class);
                            Log.e("user",Constant.USER_STATUS.toString());
                            //写入sharedpreferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("user",gson.toJson(Constant.USER_STATUS));
                            editor.commit();
                            Intent intent = new Intent(LoginActivity.this,PersonalCenterActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, rsp, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3:
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                    Constant.USER_STATUS = gson.fromJson(rsp,User.class);
                    Log.e("user",Constant.USER_STATUS.toString());
                    //写入sharedpreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user",gson.toJson(Constant.USER_STATUS));
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,PersonalCenterActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("loginInfo",MODE_PRIVATE);
        setContentView(R.layout.activity_login);
        findViews();
        bindListener();
    }

    private void findViews() {
        etPhoneNum = findViewById(R.id.et_phone_num);
        etPwd = findViewById(R.id.et_pwd);
        imageView = findViewById(R.id.imageView);
        tvForget = findViewById(R.id.tv_forget);
        tvNumLogin = findViewById(R.id.tv_num_login);
        btnLogin = findViewById(R.id.btn_login);
        ivLeft = findViewById(R.id.iv_left);
    }

    private void bindListener() {
        MyListener myListener = new MyListener();
        imageView.setOnClickListener(myListener);
        tvForget.setOnClickListener(myListener);
        tvNumLogin.setOnClickListener(myListener);
        btnLogin.setOnClickListener(myListener);
        ivLeft.setOnClickListener(myListener);
    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView:
                    if (etPwd.getInputType() == 129) {//129:不显示密码，128：密码形式
                        etPwd.setInputType(128);
                        Glide.with(LoginActivity.this).load(R.drawable.open).into(imageView);
                    } else {
                        etPwd.setInputType(129);
                        Glide.with(LoginActivity.this).load(R.drawable.close).into(imageView);
                    }
                    break;
                case R.id.tv_num_login:
                    sendCode(LoginActivity.this);
                    break;
                case R.id.tv_forget:
                    sendCode1(LoginActivity.this);
                    break;
                case R.id.btn_login:
                    login();
                    break;
                case  R.id.iv_left:
                    finish();
                    break;
            }
        }
    }




    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    // 国家代码，如“86”
                    String country = (String) phoneMap.get("country");
                    // 手机号码，如“13800138000”
                    phone = (String) phoneMap.get("phone");
                    numLogin();
                } else {
                    Toast.makeText(LoginActivity.this, "您输入的验证码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
        page.show(context);
    }

    public void sendCode1(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    // 国家代码，如“86”
                    String country = (String) phoneMap.get("country");
                    // 手机号码，如“13800138000”
                    String phone = (String) phoneMap.get("phone");
                    Intent intent = new Intent(LoginActivity.this, ForgetFindActivity.class);
                    intent.putExtra("phone",phone);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "您输入的验证码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
        page.show(context);
    }



    /**
     * 手机号密码登录
     */
    private void login() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("phone", etPhoneNum.getText().toString())
                .add("pwd", etPwd.getText().toString())
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constant.BASE_URL + "center/login")//设置网络请求的地址
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
                Log.e("rsp", rsp);
                Message msg = new Message();
                msg.what = 1;
                mainHandle.sendMessage(msg);

            }
        });

    }

    /**
     * 手机号快速登录
     */
    private void numLogin() {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("phone", phone)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constant.BASE_URL + "center/numLogin")//设置网络请求的地址
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
                Log.e("rspNum", rsp);
                Message msg = new Message();
                msg.what = 1;
                mainHandle.sendMessage(msg);

            }
        });

    }

    /**
     * qq登录
     */
    private void qqLogin(String id, String username) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("qqId", id)
                .add("username",username)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(Constant.BASE_URL + "center/qqLogin")//设置网络请求的地址
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
                Log.e("rsp", rsp);
                Message msg = new Message();
                msg.what = 2;
                mainHandle.sendMessage(msg);

            }
        });

    }


    /**
     * 注册手机号
     */
    public void sendCode2(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    // 国家代码，如“86”
                    String country = (String) phoneMap.get("country");
                    // 手机号码，如“13800138000”
                    QQphone = (String) phoneMap.get("phone");

                } else{

                }
            }
        });
        page.show(context);
    }
}
