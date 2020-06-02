package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static com.example.msl.learning_chinese.Constant.BASE_URL;
import static com.example.msl.learning_chinese.Constant.USER_STATUS;

public class SelectLevelBooksActivity extends AppCompatActivity {
    private ListView lvBooks;
    private ImageView imgHead;
    private TextView tvUsername;
    private TextView tvBook;
    private String str;
    private List<Level> books;
    private Gson gson;
    private SelectBooksAdapter selectBooksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level_books);
        findViews();
//        imgHead = findViewById(R.id.img_head);
        //头像设置
        //头像设置
        RequestOptions options = new RequestOptions()
                .circleCrop()//圆形剪裁
                .placeholder(R.drawable.head)//请求过程中显示
                .error(R.drawable.head)//请求失败显示
                .fallback(R.drawable.head);//请求的URL为null时显示
        Glide.with(this)
                .asBitmap()
                .load(BASE_URL + "images/headPicture/" + USER_STATUS.getImg()).apply(options)
                .into(imgHead);
        tvUsername.setText(Constant.USER_STATUS.getUserName());

//        lvBooks = findViewById(R.id.lv_books);
        Intent intent = getIntent();
        tvBook.setText(intent.getStringExtra("book"));
        str = intent.getStringExtra("books");
        init();
    }
    private void init(){
        gson = new GsonBuilder().create();
        books = gson.fromJson(str,new TypeToken<List<Level>>(){}.getType());
        Log.e("异步GET请求结果", books.toString());
        selectBooksAdapter = new SelectBooksAdapter(books,R.layout.item_select_book,this);
        lvBooks.setAdapter(selectBooksAdapter);
    }
    private void findViews(){
        imgHead = findViewById(R.id.img_head);
        lvBooks = findViewById(R.id.lv_books);
        tvUsername = findViewById(R.id.tv_username);
        tvBook = findViewById(R.id.tv_book);
    }
}
