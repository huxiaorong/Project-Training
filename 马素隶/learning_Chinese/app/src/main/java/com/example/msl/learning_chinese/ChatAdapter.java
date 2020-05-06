package com.example.msl.learning_chinese;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private  Context context;
    private List<Msg> mDatas;
    private PopupWindow popupWindow = null;
    private View popupView = null;
    private Idiom idiom;
    private Activity activity;

    public ChatAdapter(Context context, List<Msg> datas,Idiom idiom,Activity activity) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context.getApplicationContext());
        mDatas = datas;
        this.idiom = idiom;
        this.activity = activity;
    }

    public ChatAdapter(Activity context, List<Msg> datas,Activity activity) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context.getApplicationContext());
        mDatas = datas;
        this.activity = activity;
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
            return new ChatLeftViewHolder(view);
        } else {
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
            ((ChatLeftViewHolder) holder).mTvMsgLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("111","123456");
                    showPopupWindow();
                }
            });
        }else if(holder instanceof ChatRightViewHolder){
            ((ChatRightViewHolder) holder).mTvRightTime.setText(time);
            ((ChatRightViewHolder) holder).mTvMsgRight.setText(content);
            ((ChatRightViewHolder) holder).mTvMsgRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("111","123");
                    showPopupWindow();
                }
            });
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

    // 显示PopupWindow
    private void showPopupWindow() {
        // 创建popupWindow对象
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过布局填充器创建View
        LayoutInflater inflater = LayoutInflater.from(context);
        popupView = inflater
                .inflate(R.layout.activity_popwindow, null);
        // 设置PopupWindow显示的内容视图
        popupWindow.setContentView(popupView);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否相应点击事件
        popupWindow.setTouchable(true);

        TextView tvWord=popupView.findViewById(R.id.tv_word);
        TextView tvPin=popupView.findViewById(R.id.tv_pin);
        TextView tvPhrase = popupView.findViewById(R.id.tv_phrase);
        ImageView ivListen = popupView.findViewById(R.id.iv_listen);
        tvWord.setText(idiom.getIdiom());
        tvPin.setText(idiom.getPinyin());
        tvPhrase.setText(idiom.getParaphrase());
        ivListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TTSUtility ttsUtility = new TTSUtility(context);
                ttsUtility.speaking(idiom.getIdiom());
                ttsUtility.speaking(idiom.getParaphrase());
            }
        });

        //popupWindow.setBackgroundDrawable(this.getResources().getDrawable(
        //R.mipmap.ic_launcher));// 设置背景图片，不能在布局中设置，要通过代码来设置

        /*// 在指定控件下方显示PopupWindow
        popupWindow.showAsDropDown(tvQues,10,100);*/

        //背景变为透明
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.5f; //0.0-1.0
        activity.getWindow().setAttributes(lp);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1.0f; //0.0-1.0
                activity.getWindow().setAttributes(lp);
            }
        });

        //int weight = getWindowManager().getDefaultDisplay().getWidth();

        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(mLayoutInflater.inflate(R.layout.item_chat_left,null),Gravity.BOTTOM,0,0);
        TTSUtility ttsUtility = new TTSUtility(context);
        ttsUtility.speaking(idiom.getIdiom());

    }
}