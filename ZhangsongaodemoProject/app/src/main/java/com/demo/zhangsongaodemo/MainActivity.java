package com.demo.zhangsongaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.zhangsongaodemo.FragmentTest.TextFragmentActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tv_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_fragment=(TextView)findViewById(R.id.tv_fragment);

        initListener();

    }

    public void initListener(){
        tv_fragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_fragment:
                Intent intent=new Intent(this, TextFragmentActivity.class);
                startActivity(intent);
                break;
        }
    }
}
