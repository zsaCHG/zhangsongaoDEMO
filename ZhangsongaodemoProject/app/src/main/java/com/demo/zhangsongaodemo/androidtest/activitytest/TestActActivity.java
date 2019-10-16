package com.demo.zhangsongaodemo.androidtest.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.demo.zhangsongaodemo.FragmentTest.TextFragmentActivity;
import com.demo.zhangsongaodemo.R;

public class TestActActivity extends Activity {

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_act);

        constraintLayout = findViewById(R.id.text_act_root);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActActivity.this, SingleTastActivity.class);
                startActivity(intent);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TestActActivity.this, TextFragmentActivity.class);
                        startActivity(intent);
                    }
                }, 5000);
            }
        });
    }
}
