package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MyMistakeFragment extends Fragment {

    private ListView listView;
    private List<Word> wordList = new ArrayList<>();
    private String strSentences;
    private String strExplanation;

    private Handler mainHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    findMovieTypeById();
                    break;
                case 2:
                    LikeAdapter adapter = new LikeAdapter(wordList, R.layout.item_like, getActivity());
                    listView.setAdapter(adapter);
                    setListViewHeightBasedOnChildren(listView);
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_like, container, false);
        //填充adapter
        listView = view.findViewById(R.id.lv_list_like);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),WordDetailsActivity.class);
            }
        });

        getMyMistake();
        listClicked();
        return view;
    }



    private void listClicked() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),LikeFragment.class);
                intent.putExtra("wordId",wordList.get(position).getWord());
                intent.putExtra("wordId",wordList.get(position).getSentence1());
                intent.putExtra("wordId",wordList.get(position).getExplanation());
                //intent.putExtra("position",id);
                startActivity(intent);
            }
        });
    }


    public void getMyMistake() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "center/getMistake?userId=" + Constant.USER_STATUS.getId())
                .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                strExplanation = response.body().string();
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                wordList = gson.fromJson(strExplanation, new TypeToken<List<Word>>() {
                }.getType());
                //Log.e("movie",movieList.get(0).toString());
                Message msg = new Message();
                msg.what = 1;
                mainHandle.sendMessage(msg);
            }
        });
    }






    //根据当前的ListView的列表项计算列表的尺寸,
    // 解决ScrollView嵌套ListView时，会无法正确的计算ListView的大小
    public void setListViewHeightBasedOnChildren(ListView listView) {
        /**
         * by zsx
         * 获取ListView对应的Adapter
         * 这里的adapter是你为listview所添加的adapter，可以是原始adapter，
         * 也可以是自己定义的adapter，本人这里的articleadpter是自己定义的adapter
         */
        LikeAdapter listAdapter = (LikeAdapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    //根据当前的ListView的列表项计算列表的尺寸,
    // 解决ScrollView嵌套ListView时，会无法正确的计算ListView的大小
    public void setListViewHeightBasedOnChildren1(ListView listView) {
        /**
         * by zsx
         * 获取ListView对应的Adapter
         * 这里的adapter是你为listview所添加的adapter，可以是原始adapter，
         * 也可以是自己定义的adapter，本人这里的articleadpter是自己定义的adapter
         */
        WordAdapter listAdapter = (WordAdapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


}
