package com.demo.zhangsongaodemo.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.zhangsongaodemo.R;

public class LayoutParamsTest extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_params_test);
        textView=(TextView) findViewById(R.id.tv_layoutparams_test);
        getLayoutParams();
        setLayoutParams();
        getLayoutParams();
    }

    /**
     *  设置layoutParams
     */
    public void setLayoutParams(){
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width=3000;
        textView.setLayoutParams(layoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLayoutParams();
    }

    public void getLayoutParams(){
        if (textView.getLayoutParams() != null) {
            Log.d("dfdfsss","ddddd");
        }else {
            Log.d("dfdfsss","ddddd11111");
        }
    }
}
