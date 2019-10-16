package com.demo.zhangsongaodemo.androidtest;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.demo.zhangsongaodemo.R;

public class SurfaceViewActivity extends Activity {

    private MediaSurfaceView mediaSurfaceView;

    private ImageView iv_normal;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        mediaSurfaceView=findViewById(R.id.msv_test);
        iv_normal=findViewById(R.id.iv_normal);
        iv_normal.setImageResource(R.drawable.tanchuang);
        initSurfaceAnim();
        initNotSurfaceAnim();
    }

    private void mackMainThreadBusy(){
        for (int i = 0; i < 30000; i++) {
            if (i==0) {
                initNotSurfaceAnim();
                initSurfaceAnim();
            }
            if (handler == null) {
                handler=new Handler();
            }
            final int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("time", finalI +"///");
                }
            },100*i);
        }
    }

    private void  initSurfaceAnim(){
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,1300);
        valueAnimator.setDuration(9000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value=Float.valueOf(String.valueOf(animation.getAnimatedValue()));
                Rect rect=new Rect(0,value.intValue(),500,500+value.intValue());
                mediaSurfaceView.updatePositionAndSize(rect);
            }
        });
        Float value=Float.valueOf(String.valueOf(0));
        Rect rect=new Rect(0,value.intValue(),500,500+value.intValue());
        mediaSurfaceView.updatePositionAndSize(rect);
        valueAnimator.setStartDelay(500);
        valueAnimator.start();
    }

    private void  initNotSurfaceAnim(){
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,1300);
        valueAnimator.setDuration(9000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value=Float.valueOf(String.valueOf(animation.getAnimatedValue()));
                iv_normal.setY(value);
            }
        });
        valueAnimator.setStartDelay(500);
//        valueAnimator.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mackMainThreadBusy();
    }
}
