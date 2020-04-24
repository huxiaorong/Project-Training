package com.example.administrator.leachinese;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class SelectBooksAdapter extends BaseAdapter {
    private List<Level> books = new ArrayList<>();
    private int itemId;
    private Context context;
    private ViewHolder viewHolder;

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
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("levelBook",books.get(position).getLevelName());
                intent.putExtra("levelId",books.get(position).getId());
                context.startActivity(intent);
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
}
