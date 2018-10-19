package com.demo.zhangsongaodemo.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.zhangsongaodemo.R;

public class LayoutParamsTest extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_layout_params_test,null);
//        textView=(TextView) view.findViewById(R.id.tv_layoutparams_test);
        textView=new TextView(this);
        getLayoutParams();
        setContentView(view);
        getLayoutParams();
        setLayoutParams();
        getLayoutParams();
        addContentView(textView,textView.getLayoutParams());
    }

    /**
     *  设置layoutParams
     */
    public void setLayoutParams(){
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width=3000;
        LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(layoutParams);
        textView.setLayoutParams(layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLayoutParams();
    }

    public void getLayoutParams(){
        ViewGroup.LayoutParams view=textView.getLayoutParams();
        if (textView.getLayoutParams() != null) {
            Log.d("dfdfsss","ddddd");
        }else {
            Log.d("dfdfsss","ddddd11111");
        }
    }
}
