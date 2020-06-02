package com.example.msl.learning_chinese;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TiActivity extends Activity implements View.OnClickListener{

    private ArrayList<Ti> tilist;//数据
    private TextView titleTxt;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button upBtn;
    private Button downBtn;
    private int sel_answer=0;
    private int cur_ti=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti);
        tilist = new ArrayList<Ti>();
        titleTxt = findViewById(R.id.title);
        oneBtn = findViewById(R.id.sel1);
        oneBtn.setOnClickListener(this);
        twoBtn = findViewById(R.id.sel2);
        twoBtn.setOnClickListener(this);
        threeBtn = findViewById(R.id.sel3);
        threeBtn.setOnClickListener(this);
        fourBtn = findViewById(R.id.sel4);
        fourBtn.setOnClickListener(this);
        upBtn = findViewById(R.id.upbtn);
        upBtn.setOnClickListener(this);
        downBtn = findViewById(R.id.downbtn);
        downBtn.setOnClickListener(this);

        initData();
    }

    //调用接口获取数据
    public void initData() {
        String url = "http://10.0.2.2:8080/daystu-java/ti";
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Message msg = new Message();
                msg.what = ERROR;
                msg.obj = "网络请求失败";
                mHandler.sendMessage(msg);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String info = response.body().string();//获取服务器返回的json格式数据
                    JSONObject jsonObject = JSON.parseObject(info);//获得一个JsonObject的对象
                    int code = jsonObject.getObject("code", Integer.class);
                    if (200 == code)//如果code等于200，则说明存在该用户，而且服务器还返回了该用户的信息
                    {
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        Message msg=new Message();
                        msg.what=SUCCESS;
                        msg.obj=jsonArray;
                        mHandler.sendMessage(msg);
                    }else{
                        String message = jsonObject.getObject("message", String.class);
                        Message msg = new Message();
                        msg.what = ERROR;
                        msg.obj = message;
                        mHandler.sendMessage(msg);
                    }
                }
            }
        });
    }

    private static int SUCCESS=0x123;
    private static int ERROR=0x124;

    //Handler方式实现子线程和主线程间的通信
    Handler mHandler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (SUCCESS == msg.what) {
                tilist.clear();
                JSONArray jsonArray = (JSONArray) msg.obj;
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    Ti ti=new Ti();
                    ti.setId(obj.getInteger("id"));
                    ti.setAnswer(obj.getInteger("answer"));
                    ti.setSel1(obj.getString("sel1"));
                    ti.setSel2(obj.getString("sel2"));
                    ti.setSel3(obj.getString("sel3"));
                    ti.setSel4(obj.getString("sel4"));
                    ti.setTitle(obj.getString("title"));
                    tilist.add(ti);
                }

                //设置当前题目
                setti();
            }
            else if (ERROR==msg.what)
            {
                String info= (String) msg.obj;
                Toast.makeText(TiActivity.this, info, Toast.LENGTH_SHORT).show();
                if(info.equals("暂无复习题")){
                    tilist.clear();
                }
            }
        }
    };

    //判断按钮点击
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sel1:
                sel_answer=1;
                disrs();
                break;
            case R.id.sel2:
                sel_answer=2;
                disrs();
                break;
            case R.id.sel3:
                sel_answer=3;
                disrs();
                break;
            case R.id.sel4:
                sel_answer=4;
                disrs();
                break;
            case R.id.upbtn:
                if(sel_answer==0){
                    Toast.makeText(TiActivity.this, "请作答", Toast.LENGTH_SHORT).show();
                }else {
                    cur_ti = cur_ti - 1;
                    if (cur_ti < 0) {
                        cur_ti = 0;
                    }
                    setti();
                }
                break;
            case R.id.downbtn:
                if(sel_answer==0){
                    Toast.makeText(TiActivity.this, "请作答", Toast.LENGTH_SHORT).show();
                }else {
                    cur_ti = cur_ti + 1;
                    if (cur_ti > tilist.size()) {
                        cur_ti = tilist.size() - 1;
                    }
                    setti();
                }
                break;
        }
    }

    //显示结果
    public void disrs(){
        Ti ti=tilist.get(cur_ti);
        if(sel_answer==ti.getAnswer()){
            Toast.makeText(TiActivity.this, "选择正确", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(TiActivity.this, "选择错误", Toast.LENGTH_SHORT).show();
        }
    }

    //设置题目
    public void setti(){
        Ti ti=tilist.get(cur_ti);
        titleTxt.setText(ti.getTitle());
        oneBtn.setText(ti.getSel1());
        twoBtn.setText(ti.getSel2());
        threeBtn.setText(ti.getSel3());
        fourBtn.setText(ti.getSel4());
        sel_answer=0;
    }
}
