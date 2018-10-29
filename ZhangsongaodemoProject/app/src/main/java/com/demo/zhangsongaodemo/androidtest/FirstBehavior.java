package com.demo.zhangsongaodemo.androidtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zsachg on 2018/10/28.
 */

public class FirstBehavior extends android.support.design.widget.CoordinatorLayout.Behavior{
    @Override
    public boolean layoutDependsOn(android.support.design.widget.CoordinatorLayout parent, View child, View dependency) {
        return true;
    }

    @Override
    public boolean onDependentViewChanged(android.support.design.widget.CoordinatorLayout parent, View child, View dependency) {
        child.setX(dependency.getX()+30);
        return true;
    }

    /**
     * Default constructor for instantiating Behaviors.
     */
    public FirstBehavior() {
    }


    public FirstBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
