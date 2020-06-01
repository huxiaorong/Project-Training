package com.example.msl.learning_chinese;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

import static com.example.msl.learning_chinese.StringUtil.cutStr;

public class WordBookAdapter extends BaseAdapter {
    private List<Word> books = new ArrayList<>();
    private int itemId;
    private Context context;
    private ViewHolder viewHolder;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    private  Intent intent;

    public WordBookAdapter(List<Word> books, int itemId, Context context){
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
            viewHolder.tvWord = convertView.findViewById(R.id.tv_word);
            viewHolder.tvParaphrase = convertView.findViewById(R.id.tv_paraphrase);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.tvWord.setText(books.get(position).getWord());
        viewHolder.tvParaphrase.setText(cutStr(books.get(position).getExplanation(),23));

        return convertView;
    }
    private class ViewHolder{
        private TextView tvWord;
        private TextView tvParaphrase;
    }



}
