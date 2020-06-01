package com.example.msl.learning_chinese;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends BaseAdapter {
    private List<Word> wordList=new ArrayList<>();
    private int itemId;
    private FragmentActivity  context;
    private ViewHolder viewHolder;

    public WordAdapter(List<Word> wordList, int itemId, FragmentActivity context) {
        this.wordList = wordList;
        this.itemId = itemId;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(null!=wordList){
            return wordList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(null!=wordList){
            return wordList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(itemId,null);
            viewHolder=new ViewHolder();
            viewHolder.tvWord=convertView.findViewById(R.id.tv_word_Chinese_like );
            viewHolder.tvSentence1=convertView.findViewById(R.id.tv_word_word_like );
            viewHolder.tvExplanation=convertView.findViewById(R.id.tv_word_Chinese_description_like);
//            viewHolder.imgDelete=convertView.findViewById(R.id.img_delete_like);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.tvWord.setText(wordList.get(position).getWord());
        viewHolder.tvSentence1.setText(wordList.get(position).getSentence1());
        viewHolder.tvExplanation.setText(wordList.get(position).getExplanation());

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.loading)//请求过程中显示
                .error(R.drawable.error)//请求失败显示
                .fallback(R.drawable.defaultimg);//请求的URL为null时显示
//        Glide.with(context)
//                .load(Constant.BASE_URL+"hotCity/"+with.get(position).getImg())
//                .placeholder(R.drawable.loading)//请求过程中显示
//                .error(R.drawable.error)//请求失败显示
//                .fallback(R.drawable.defaultimg)
//                .into(viewHolder.imgDelete);

//        viewHolder.imgDelete.setImageResource(wordList.get(position).());
        return convertView;
    }

    private class ViewHolder{
        private TextView tvWord;
        private TextView tvExplanation;
        private TextView tvSentence1;
        private ImageView imgDelete;

    }
}

