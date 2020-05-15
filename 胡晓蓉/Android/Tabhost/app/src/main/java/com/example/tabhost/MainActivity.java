package com.example.tabhost;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private class MyTabSpec {
        private ImageView imageView = null;
        private TextView textView = null;
        private int normalImage;
        private int selectImage;
        private Fragment fragment = null;

        // 设置是否被选中
        private void setSelect(boolean b) {
            if(b) {
                imageView.setImageResource(selectImage);
                textView.setTextColor(
                        Color.parseColor("#0000FF"));
            } else {
                imageView.setImageResource(normalImage);
                textView.setTextColor(
                        Color.parseColor("#000000"));
            }
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public int getNormalImage() {
            return normalImage;
        }

        public void setNormalImage(int normalImage) {
            this.normalImage = normalImage;
        }

        public int getSelectImage() {
            return selectImage;
        }

        public void setSelectImage(int selectImage) {
            this.selectImage = selectImage;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }
    }

    private Map<String, MyTabSpec> map = new HashMap<>();
    private String [] tabStrId = {"首页", "复习", "趣学"};
    // 用于记录当前正在显示的Fragment
    private Fragment curFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1、初始化，初始化MyTabSpec对象
        // Fragment、ImageView、TextView、normalImage、selectImage
        initData();

        // 2、设置监听器，在监听器中完成切换
        setListener();

        // 3、设置默认显示的TabSpec
        changeTab(tabStrId[0]);
    }

    // 自定义的监听器类，完成Tab页面切换及图表转化
    private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tab_spec_homepage:
                    changeTab(tabStrId[0]);
                    break;
                case R.id.tab_spec_fuxi:
                    changeTab(tabStrId[1]);
                    break;
                case R.id.tab_spec_quxue:
                    changeTab(tabStrId[2]);
                    break;
            }
        }
    }

    // 根据Tab ID 切换Tab
    private void changeTab(String s) {
        // 1 切换Fragment
        changeFragment(s);

        // 2 切换图标及字体颜色
        changeImage(s);
    }

    // 根据Tab ID 切换 Tab显示的Fragment
    private void changeFragment(String s) {
        Fragment fragment = map.get(s).getFragment();

        if(curFragment == fragment) return;

        // Fragment事务 - Fragment事务管理器来获取
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        // 将之前你显示的Fragment隐藏掉
        if(curFragment!=null)
            transaction.hide(curFragment);

        // 如果当前Fragment没有被添加过，则添加到
        // Activity的帧布局中
        if(!fragment.isAdded()) {
            transaction.add(R.id.tab_content, fragment);
        }
        // 显示对应Fragment
        transaction.show(fragment);
        curFragment = fragment;

        transaction.commit();
    }

    // 根据Tab ID 切换 Tab显示的图片及字体颜色
    private void changeImage(String s) {
        // 1 所有Tab的图片和字体颜色恢复默认
        for (String key : map.keySet()) {
            map.get(key).setSelect(false);
        }

        // 2 设置选中的Tab的图片和字体颜色
        map.get(s).setSelect(true);
    }

    // 设置监听器
    private void setListener() {
        LinearLayout layout1 = findViewById(R.id.tab_spec_homepage);
        LinearLayout layout2 = findViewById(R.id.tab_spec_fuxi);
        LinearLayout layout3 = findViewById(R.id.tab_spec_quxue);

        MyListener listener = new MyListener();
        layout1.setOnClickListener(listener);
        layout2.setOnClickListener(listener);
        layout3.setOnClickListener(listener);
    }

    // 初始化，初始化MyTabSpec对象
    private void initData() {
        // 1 创建MyTabSpec对象
        map.put(tabStrId[0], new MyTabSpec());
        map.put(tabStrId[1], new MyTabSpec());
        map.put(tabStrId[2], new MyTabSpec());

        // 2 设置Fragment
        setFragment();

        // 3 设置ImageView和TextView
        findView();

        // 4 设置图片资源
        setImage();
    }

    // 将图片资源放入map的MyTabSpec对象中
    private void setImage() {
        map.get(tabStrId[0]).setNormalImage(R.drawable.homepagenormal);
        map.get(tabStrId[0]).setSelectImage(R.drawable.homepageselect);
        map.get(tabStrId[1]).setNormalImage(R.drawable.fuxinormal);
        map.get(tabStrId[1]).setSelectImage(R.drawable.fuxiselect);
        map.get(tabStrId[2]).setNormalImage(R.drawable.youxinormal);
        map.get(tabStrId[2]).setSelectImage(R.drawable.youxiselect);
    }

    // 创建Fragment对象并放入map的MyTabSpec对象中
    private void setFragment() {
        map.get(tabStrId[0]).setFragment(new CenterFragment());
        map.get(tabStrId[1]).setFragment(new RefresherFragment());
        map.get(tabStrId[2]).setFragment(new GamesFragment());
    }

    //     将ImageView和TextView放入map中的MyTabSpec对象
    private void findView() {
        ImageView iv1 = findViewById(R.id.img_1);
        ImageView iv2 = findViewById(R.id.img_2);
        ImageView iv3 = findViewById(R.id.img_3);
        TextView tv1 = findViewById(R.id.tv_1);
        TextView tv2 = findViewById(R.id.tv_2);
        TextView tv3 = findViewById(R.id.tv_3);

//        map.get(tabStrId[0]).setImageView(iv1);
        map.get(tabStrId[0]).setTextView(tv1);

        map.get(tabStrId[1]).setImageView(iv2);
        map.get(tabStrId[1]).setTextView(tv2);

        map.get(tabStrId[2]).setImageView(iv3);
        map.get(tabStrId[2]).setTextView(tv3);
    }
}
