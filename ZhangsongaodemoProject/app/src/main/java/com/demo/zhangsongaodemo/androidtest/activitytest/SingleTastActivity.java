package com.demo.zhangsongaodemo.androidtest.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.demo.zhangsongaodemo.MainActivity;
import com.demo.zhangsongaodemo.R;

public class SingleTastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_tast);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SingleTastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
