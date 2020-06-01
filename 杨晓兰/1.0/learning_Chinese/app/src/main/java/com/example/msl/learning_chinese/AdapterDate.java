package com.example.msl.learning_chinese;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AdapterDate extends BaseAdapter {

    private int[] thisMonth;
    private Context context;
    private List<Integer> days = new ArrayList<>();
    private OkHttpClient okHttpClient = new OkHttpClient();
    //日历数据
    private List<Boolean> status = new ArrayList<>();
    //签到状态，实际应用中初始化签到状态可通过该字段传递
//    private OnSignedSuccess onSignedSuccess;
    //签到成功的回调方法，相应的可自行添加签到失败时的回调方法

    public AdapterDate(Context context) {
        this.context = context;
        int maxDay = DateUtil.getCurrentMonthLastDay();//获取当月天数
        for (int i = 0; i < DateUtil.getFirstDayOfMonth() - 1; i++) {
            //DateUtil.getFirstDayOfMonth()获取当月第一天是星期几，星期日是第一天，依次类推
            days.add(0);
            //0代表需要隐藏的item
            status.add(false);
            //false代表为签到状态
        }
        findThisWeek();
    }

    @Override
    public int getCount() {
        return days.size();
    }

    @Override
    public Object getItem(int i) {
        return days.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_gv,null);
            viewHolder = new ViewHolder();
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv = view.findViewById(R.id.tvWeek);
        viewHolder.rlItem = view.findViewById(R.id.rlItem);
//        viewHolder.ivStatus = view.findViewById(R.id.ivStatus);
        viewHolder.tv.setText(days.get(i)+"");
        if(days.get(i)==0){
            viewHolder.rlItem.setVisibility(View.GONE);
        }
        if(status.get(i)){
            viewHolder.tv.setTextColor(Color.parseColor("#1ABFB2"));
//            viewHolder.ivStatus.setVisibility(View.VISIBLE);
        }else{
            viewHolder.tv.setTextColor(Color.parseColor("#666666"));
//            viewHolder.ivStatus.setVisibility(View.GONE);
        }
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(status.get(i)){
//                    Toast.makeText(context,"Already sign in!",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(context,"Sign in success!",Toast.LENGTH_SHORT).show();
//                    status.set(i,true);
//                    notifyDataSetChanged();
//                    if(onSignedSuccess!=null){
//                        onSignedSuccess.OnSignedSuccess();
//                    }
//                }
//            }
//        });
        return view;
    }

    class ViewHolder{
        RelativeLayout rlItem;
        TextView tv;
//        ImageView ivStatus;
    }

//    public void setOnSignedSuccess(OnSignedSuccess onSignedSuccess){
//        this.onSignedSuccess = onSignedSuccess;
//    }
    /*
    获取本周学习记录
    */
    private void findThisWeek() {
        Log.e("request", "start");
        //2.创建Request对象
        final Request request = new Request.Builder()
                .url(Constant.BASE_URL + "record/find/thisMonth?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
                .build();
        //3.创建Call对象
        Call call = okHttpClient.newCall(request);
        //4.发送请求
        //异步请求，不需要创建线程
        call.enqueue(new Callback() {
            @Override
            //请求失败时回调
            public void onFailure(Call call, IOException e) {
                Log.e("failure", "error");
                Log.e("error", e.getMessage());
                e.printStackTrace();//打印异常信息
            }

            @Override
            //请求成功之后回调
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                int maxDay = DateUtil.getCurrentMonthLastDay();//获取当月天数
                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
                thisMonth = gson.fromJson(reStr,int[].class);
                for (int i = 0; i < maxDay; i++) {
                    days.add(i+1);
                    //初始化日历数据

                    if (thisMonth[i]==1){
                        status.add(true);
                    }else {
                        status.add(false);
                    }
                    //初始化日历签到状态
                }

            }
        });

    }
}
