package com.example.msl.learning_chinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class BaiduDetailsActivity extends AppCompatActivity {

    private WebView webView;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_details);
        webView = findViewById(R.id.webView);

        Intent intent  = getIntent();
        String word = intent.getStringExtra("word");
        Log.e("word",word);
        webView.loadUrl("https://hanyu.baidu.com/s?wd="+word+"&ptype=zici");
        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
