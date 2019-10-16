package com.demo.zhangsongaodemo.viewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.demo.zhangsongaodemo.R;

public class ViewActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private View v_view_test;

    private ParentLinearLayout pll_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        v_view_test = findViewById(R.id.v_view_test);
        pll_view = findViewById(R.id.pll_view);
        final GestureDetector gestureDetector = new GestureDetector(this);
        gestureDetector.setIsLongpressEnabled(false);

//        v_view_test.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                VelocityTracker velocityTracker = VelocityTracker.obtain();
//                velocityTracker.addMovement(event);
//
//                velocityTracker.computeCurrentVelocity(1000);
//                velocityTracker.getXVelocity();
//                velocityTracker.getYVelocity();
//                velocityTracker.getXVelocity();
//
//                gestureDetector.onTouchEvent(event);
//
//
//                return true;
//            }
//        });

        Scroller scroller=new Scroller(this);
        scroller.startScroll(0,0,0,0,1000);

        pll_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Touch","parent Click");
            }
        });

        v_view_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Touch","child Click");
            }
        });


    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","activity onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
