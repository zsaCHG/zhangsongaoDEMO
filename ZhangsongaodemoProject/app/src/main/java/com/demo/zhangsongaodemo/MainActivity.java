package com.demo.zhangsongaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.zhangsongaodemo.FragmentTest.TextFragmentActivity;
import com.demo.zhangsongaodemo.androidtest.LayoutParamsTest;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tv_fragment;

    private TextView tv_layoutparams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_fragment=(TextView) findViewById(R.id.tv_fragment);
        tv_layoutparams=(TextView)findViewById(R.id.tv_layoutparams);
        initListener();

    }

    public void initListener(){
        tv_fragment.setOnClickListener(this);
        tv_layoutparams.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_fragment:
                Intent intent=new Intent(this, TextFragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_layoutparams:
                Intent intent1=new Intent(this, LayoutParamsTest.class);
                startActivity(intent1);
                break;
        }
    }
}
