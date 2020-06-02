package com.example.msl.learning_chinese;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SelectBooksAdapter extends BaseAdapter {
    private List<Level> books = new ArrayList<>();
    private int itemId;
    private Context context;
    private ViewHolder viewHolder;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private int curTag;
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    private  Intent intent;

    public SelectBooksAdapter(List<Level> books,int itemId,Context context){
        this.books = books;
        this.itemId = itemId;
        this.context =context;
    }
    @Override
    public int getCount() {
        if(null!=books){
            return books.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(null!=books){
            return books.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(itemId,null);
            viewHolder = new ViewHolder();
            viewHolder.tvbook = convertView.findViewById(R.id.tv_book);
            viewHolder.llBook = convertView.findViewById(R.id.ll_book);
            viewHolder.imgBook = convertView.findViewById(R.id.img_book);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.tvbook.setText(books.get(position).getLevelName());
        viewHolder.llBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curTag = books.get(position).getId();
                updateLevel();
                intent = new Intent(context,MainActivity.class);
                intent.putExtra("levelBook",books.get(position).getLevelName());
                intent.putExtra("levelId",books.get(position).getId());

            }
        });
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.loading)//请求过程中显示
                .error(R.drawable.error)//请求失败显示
                .fallback(R.drawable.defaultimg);//请求的URL为null时显示
        Glide.with(context)
                .load(Constant.BASE_URL+"images/books/"+books.get(position).getImg())
                .apply(options)
                .into(viewHolder.imgBook);
        return convertView;
    }
    private class ViewHolder{
        private LinearLayout llBook;
        private TextView tvbook;
        private ImageView imgBook;
    }
    /*
更新用户进度
*/
    private void updateLevel() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/update/level?userId=" + Constant.USER_STATUS.getId()+"&levelTag="+curTag)//设置网络请求的URL地址
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

                final String reStr = response.body().string();
                Log.e("异步GET请求结果", reStr);
                Constant.USER_STATUS = gson.fromJson(reStr, User.class);

                context.startActivity(intent);
            }
        });
    }

}
