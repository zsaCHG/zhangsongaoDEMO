package com.demo.zhangsongaodemo.viewtest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class CanScrollerView extends View {

    Scroller scroller;

    public CanScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanScrollerView(Context context) {
        super(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller!=null && scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            postInvalidate();
        }
    }

    public void scrollerToPosition(int x , int y){
        int dx = x-getScrollX();
        int dy = y-getScrollY();

        scroller = new Scroller(getContext());
        scroller.startScroll(getScrollX(),getScrollY(),dx,dy);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","child onTouchEvent"+event.getX());

        return super.onTouchEvent(event);
    }
}
