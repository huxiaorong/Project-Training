package com.example.msl.learning_chinese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void chick(View view) {

        Intent intent=new Intent(MainActivity.this,Game1BeginActivity.class);
        intent.putExtra("tag","main");
        startActivity(intent);
    }
}
