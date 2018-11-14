package com.demo.zhangsongaodemo.androidtest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zsachg on 2018/10/28.
 * 两种实现方式
 */

public class FirstBehavior extends android.support.design.widget.CoordinatorLayout.Behavior{
//    @Override
//    public boolean layoutDependsOn(android.support.design.widget.CoordinatorLayout parent, View child, View dependency) {
//        return dependency instanceof TextView;
//    }
//
//    @Override
//    public boolean onDependentViewChanged(android.support.design.widget.CoordinatorLayout parent, View child, View dependency) {
//        child.setX(3);
//        return true;
//    }

    /**
     * Default constructor for instantiating Behaviors.
     */
    public FirstBehavior() {
    }


    public FirstBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {

        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }


    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        Log.d("Coordinator",dx+"////"+dy);
        child.setTranslationY(dy);
        consumed[0]=dx;
        consumed[1]=dy;
    }
}
