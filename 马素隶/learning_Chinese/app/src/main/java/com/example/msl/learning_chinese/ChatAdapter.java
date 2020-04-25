package com.example.msl.learning_chinese;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private  Context context;
    private List<Msg> mDatas;

    public ChatAdapter(Activity context, List<Msg> datas) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context.getApplicationContext());
        mDatas = datas;
    }

    //添加消息显示在RecyclerView中
    public void addItem(Msg msg) {
        mDatas.add(msg);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Msg.TYPE_BLE) {
            View view = mLayoutInflater.inflate(R.layout.item_chat_left, parent, false);
            Log.e("left","123");
            return new ChatLeftViewHolder(view);
        } else {
            Log.e("right","123");
            View view = mLayoutInflater.inflate(R.layout.item_chat_right, parent, false);
            return new ChatRightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Msg msg = mDatas.get(position);
        String time = msg.getTime();
        String content = msg.getContent();
        if(holder instanceof ChatLeftViewHolder){
            ((ChatLeftViewHolder) holder).mTvLeftTime.setText(time);
            ((ChatLeftViewHolder) holder).mTvMsgLeft.setText(content);
        }else if(holder instanceof ChatRightViewHolder){
            ((ChatRightViewHolder) holder).mTvRightTime.setText(time);
            ((ChatRightViewHolder) holder).mTvMsgRight.setText(content);
            Log.e("content",content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ChatLeftViewHolder extends RecyclerView.ViewHolder {
        TextView mTvLeftTime;
        TextView mTvMsgLeft;


        public ChatLeftViewHolder(View itemView) {
            super(itemView);
            mTvLeftTime = itemView.findViewById(R.id.tv_left_time);
            mTvMsgLeft = itemView.findViewById(R.id.tv_msg_left);

        }
    }

    static class ChatRightViewHolder extends RecyclerView.ViewHolder{
        TextView mTvRightTime;
        TextView mTvMsgRight;


        public ChatRightViewHolder(View itemView) {
            super(itemView);
            mTvRightTime = itemView.findViewById(R.id.tv_right_time);
            mTvMsgRight = itemView.findViewById(R.id.tv_msg_right);

        }
    }
}