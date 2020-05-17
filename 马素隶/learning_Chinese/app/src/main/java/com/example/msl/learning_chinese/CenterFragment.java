package com.example.msl.learning_chinese;

//import android.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class CenterFragment extends Fragment {
    private ImageView imgHead;
    private TextView tvCur;
    private TextView tvGoal;
    private Button btnStart;
    private Button btnChangeBooks;
    private OkHttpClient okHttpClient;
    private Gson gson;
    private List<Word> wordList;
    private List<Word> learnedList = new ArrayList<>();
    private List<Word> notLearnedList = new ArrayList<>();

    private List<Level> books;
    private Intent intent;
    private int pageNum;
    private int wordNum;
    private List<Record> records;
    private String bookStr;
    private TextView tvBook;
    private TextView tvSun;
    private ImageView imgSun;
    private TextView tvMon;
    private ImageView imgMon;
    private TextView tvTues;
    private ImageView imgTues;
    private TextView tvWed;
    private ImageView imgWed;
    private TextView tvThur;
    private ImageView imgThur;
    private TextView tvFri;
    private ImageView imgFri;
    private TextView tvSat;
    private ImageView imgSat;
    private int totalNum;
    private TextView tvBookState;
    private int pageSize = 3;
    private Button btnWordBook;
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_center,
                container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findViews();
        wordList = new ArrayList<>();
        okHttpClient = new OkHttpClient();
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        pageNum = Constant.USER_STATUS.getStudiedTag();
        wordNum = Constant.USER_STATUS.getNumberTag();
        if ((bookStr = getActivity().getIntent().getStringExtra("levelBook")) != null) {
            tvBook.setText(bookStr);
        }

        //头像设置
        RequestOptions options = new RequestOptions()
                .circleCrop();//圆形剪裁
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.head)//图片资源id
                .into(imgHead);

        tvCur.setText("" + wordNum);
//        getNumByTag();
        getWordList();
        getBooksList();
        findToday();
        getWeekDay();
        findThisWeek();
        getTodayWeek();
        getLearnedWordList();
        toast = Toast.makeText(getActivity().getApplicationContext(), "确定退出？", Toast.LENGTH_SHORT);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wordList.size() <= wordNum) {
                    Constant.USER_STATUS.setStudiedTag(pageNum + 1);
                    Constant.USER_STATUS.setNumberTag(0);
                    pageNum = pageNum + 1;
                    wordNum = 0;
                    updateProgress();
                    reWordList();
                }
                intent = new Intent(v.getContext(), StudyActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
            }
        });

        btnChangeBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), SelectLevelBooksActivity.class);
                Log.e("books", books.toString());
                intent.putExtra("books", gson.toJson(books));
                intent.putExtra("book", tvBook.getText());
                startActivity(intent);
            }
        });

        btnWordBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), WordbookActivity.class);
                intent.putExtra("learnedList", gson.toJson(learnedList));
                intent.putExtra("notLearnedList", gson.toJson(notLearnedList));
                startActivity(intent);
            }
        });
        
    }

    private void findViews() {
        imgHead = getActivity().findViewById(R.id.img_head);
        tvCur = getActivity().findViewById(R.id.tv_cur);
        tvGoal = getActivity().findViewById(R.id.tv_goal);
        tvBook = getActivity().findViewById(R.id.tv_book);
        btnStart = getActivity().findViewById(R.id.btn_start);

        btnChangeBooks = getActivity().findViewById(R.id.btn_changebooks);

        tvSun = getActivity().findViewById(R.id.tv_sun);
        imgSun = getActivity().findViewById(R.id.img_sun);
        tvMon = getActivity().findViewById(R.id.tv_mon);
        imgMon = getActivity().findViewById(R.id.img_mon);
        tvTues = getActivity().findViewById(R.id.tv_tues);
        imgTues = getActivity().findViewById(R.id.img_tues);
        tvWed = getActivity().findViewById(R.id.tv_wed);
        imgWed = getActivity().findViewById(R.id.img_wed);
        tvThur = getActivity().findViewById(R.id.tv_thur);
        imgThur = getActivity().findViewById(R.id.img_thur);
        tvFri = getActivity().findViewById(R.id.tv_fri);
        imgFri = getActivity().findViewById(R.id.img_fri);
        tvSat = getActivity().findViewById(R.id.tv_sat);
        imgSat = getActivity().findViewById(R.id.img_sat);

        tvBookState = getActivity().findViewById(R.id.tv_book_state);

        btnWordBook = getActivity().findViewById(R.id.btn_word_book);

    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            doubleClickExit();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//
//    }

    //双击退出
//    private void doubleClickExit() {
//        // System.currentTimeMillis()无论何时调用，肯定大于2000
//        if ((System.currentTimeMillis() - exitTime) > 2000) {
//            Toast.makeText(getApplicationContext(), "再按一次返回键返回到桌面",
//                    Toast.LENGTH_SHORT).show();
//            exitTime = System.currentTimeMillis();
//        } else {
//            finish();
//            System.exit(0);
//        }
//    }
//
    //date==>week
    public int getWeek(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (w == 0) w = 7;
        return w;
    }

    public void onBackPressed() {
        quitToast();
    }

    private void quitToast() {
        if (null == toast.getView().getParent()) {
            toast.show();
        } else {
            System.exit(0);
        }
    }

    //week==>7days
    private void getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        // 获取本周的第一天
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek + i);
            // 获取星期的显示名称，例如：周一、星期一、Monday等等
            String day = new SimpleDateFormat("dd").format(calendar.getTime());

            list.add("" + Integer.parseInt(day));
        }
        tvSun.setText(list.get(0));
        tvMon.setText(list.get(1));
        tvTues.setText(list.get(2));
        tvWed.setText(list.get(3));
        tvThur.setText(list.get(4));
        tvFri.setText(list.get(5));
        tvSat.setText(list.get(6));
    }

    private void getTodayWeek() {
        tvSun.setTextColor(Color.parseColor("#4B4B4B"));
        tvMon.setTextColor(Color.parseColor("#4B4B4B"));
        tvTues.setTextColor(Color.parseColor("#4B4B4B"));
        tvWed.setTextColor(Color.parseColor("#4B4B4B"));
        tvThur.setTextColor(Color.parseColor("#4B4B4B"));
        tvFri.setTextColor(Color.parseColor("#4B4B4B"));
        tvSat.setTextColor(Color.parseColor("#4B4B4B"));
        tvSun.setBackgroundResource(R.drawable.circle3);
        tvMon.setBackgroundResource(R.drawable.circle3);
        tvTues.setBackgroundResource(R.drawable.circle3);
        tvWed.setBackgroundResource(R.drawable.circle3);
        tvThur.setBackgroundResource(R.drawable.circle3);
        tvFri.setBackgroundResource(R.drawable.circle3);
        tvSat.setBackgroundResource(R.drawable.circle3);
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            tvSun.setTextColor(Color.parseColor("#1ABFB2"));
            tvSun.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 2) {
            tvMon.setTextColor(Color.parseColor("#1ABFB2"));
            tvMon.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 3) {
            tvTues.setTextColor(Color.parseColor("#1ABFB2"));
            tvTues.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 4) {
            tvWed.setTextColor(Color.parseColor("#1ABFB2"));
            tvWed.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 5) {
            tvThur.setTextColor(Color.parseColor("#1ABFB2"));
            tvThur.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 6) {
            tvFri.setTextColor(Color.parseColor("#1ABFB2"));
            tvFri.setBackgroundResource(R.drawable.circle);
        } else if (weekday == 7) {
            tvSat.setTextColor(Color.parseColor("#1ABFB2"));
            tvSat.setBackgroundResource(R.drawable.circle);
        }
    }

    /*
    获取今日单词列表
    */
    private void getWordList() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/list?pageNum=" + pageNum + "&tag=" + Constant.USER_STATUS.getLevelTag())//设置网络请求的URL地址
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
                wordList = gson.fromJson(reStr, new TypeToken<List<Word>>() {
                }.getType());
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        tvGoal.setText("/" + wordList.size());
                        tvCur.setText("" + wordNum);
                    }
                });

            }
        });
    }

    /*
    重新今日单词列表
    */
    private void reWordList() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/list?pageNum=" + pageNum + "&tag=" + Constant.USER_STATUS.getLevelTag())//设置网络请求的URL地址
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
                wordList = gson.fromJson(reStr, new TypeToken<List<Word>>() {
                }.getType());
                intent = new Intent(getContext(), StudyActivity.class);
                intent.putExtra("wordList", gson.toJson(wordList));
                startActivity(intent);
            }
        });
    }

    /*
    获取今日学习记录
    */
    private void findToday() {
        Log.e("request", "start");
        //2.创建Request对象
        final Request request = new Request.Builder()
                .url(Constant.BASE_URL + "record/find/today?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
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
                records = gson.fromJson(reStr, new TypeToken<List<Record>>() {
                }.getType());
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        Log.e("wordNum", wordNum + "");
                        Log.e("wordList.size", wordList.size() + "");
                        if (wordNum >= wordList.size()) {

                            if (records.size() != 0) {
                                btnStart.setText("再学一组");
                            } else {
                                Constant.USER_STATUS.setStudiedTag(pageNum + 1);
                                Constant.USER_STATUS.setNumberTag(0);
                                pageNum = pageNum + 1;
                                wordNum = 0;
                                updateProgress();
                            }
                        } else {

                        }
                    }
                });

            }
        });
    }

    /*
    更新用户进度
    */
    private void updateProgress() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "user/update/progress?userId=" + Constant.USER_STATUS.getId() + "&studiedTag=" + pageNum + "&numberTag=" + wordNum)//设置网络请求的URL地址
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
            }
        });
    }

    /*
    获取年级等级书目
     */
    private void getBooksList() {
        Log.e("requestBooks", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "level/list")//设置网络请求的URL地址
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

                books = gson.fromJson(reStr, new TypeToken<List<Level>>() {
                }.getType());

            }
        });
    }

    /*
    获取本周学习记录
    */
    private void findThisWeek() {
        Log.e("request", "start");
        //2.创建Request对象
        final Request request = new Request.Builder()
                .url(Constant.BASE_URL + "record/find/thisWeek?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
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
                final List<Record> weekRecords = gson.fromJson(reStr, new TypeToken<List<Record>>() {
                }.getType());
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        imgSun.setImageDrawable(null);
                        imgMon.setImageDrawable(null);
                        imgTues.setImageDrawable(null);
                        imgWed.setImageDrawable(null);
                        imgThur.setImageDrawable(null);
                        imgFri.setImageDrawable(null);
                        imgSat.setImageDrawable(null);
                        for (Record r : weekRecords) {
                            Log.e("getActivity()", r.toString() + getWeek(r.getStudiedTime()));
                            if (getWeek(r.getStudiedTime()) == 0) {
                                imgSun.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 1) {
                                imgMon.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 2) {
                                imgTues.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 3) {
                                imgWed.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 4) {
                                imgThur.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 5) {
                                imgFri.setImageResource(R.drawable.dot);
                            } else if (getWeek(r.getStudiedTime()) == 6) {
                                imgSat.setImageResource(R.drawable.dot);
                            }
                        }
                    }
                });

            }
        });
    }

    /*
    获取本册数目生词数量
    */
    private void getNumByTag() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/count/tag?tag=" + Constant.USER_STATUS.getLevelTag())//设置网络请求的URL地址
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
                totalNum = gson.fromJson(reStr, int.class);
                final int curNum = (Constant.USER_STATUS.getStudiedTag() - 1) * pageSize + Constant.USER_STATUS.getNumberTag();
                final String percentage = String.format("%.1f", (float) curNum / totalNum * 100);
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        tvBookState.setText("已学习 " + curNum + "/" + totalNum + "(" + percentage + "%)");
                    }
                });
            }
        });
    }

    /*
    获取已学单词列表
    */
    private void getLearnedWordList() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/find/learned?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
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
                learnedList = gson.fromJson(reStr, new TypeToken<List<Word>>() {
                }.getType());
                getNotLearnedWordList();

            }
        });
    }

    /*
    获取未学单词列表
    */
    private void getNotLearnedWordList() {
        Log.e("request", "start");
        //2.创建Request对象
        Request request = new Request.Builder()
                .url(Constant.BASE_URL + "word/find/notLearned?userId=" + Constant.USER_STATUS.getId())//设置网络请求的URL地址
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
                notLearnedList = gson.fromJson(reStr, new TypeToken<List<Word>>() {
                }.getType());
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (null == learnedList) {
                            tvBookState.setText("已学习 " + 0 + "/" + notLearnedList.size() + "(" + 0 + "%)");
                        } else {
                            Log.e("learnedList.size()", learnedList.size() + "");
                            Log.e("notLearnedList.size()", notLearnedList.size() + "");
                            tvBookState.setText("已学习 " + learnedList.size() + "/" + (notLearnedList.size() + learnedList.size()) + "(" + String.format("%.1f", (float) learnedList.size() / (notLearnedList.size() + learnedList.size()) * 100) + "%)");
                        }
                    }
                });
            }
        });
    }
}
