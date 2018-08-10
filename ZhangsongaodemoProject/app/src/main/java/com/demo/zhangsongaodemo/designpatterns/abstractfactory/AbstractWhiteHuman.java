package com.demo.zhangsongaodemo.designpatterns.abstractfactory;

import android.util.Log;

/**
 * Created by zsachg on 2018/8/9.
 */

public abstract class AbstractWhiteHuman implements Human {



    @Override
    public void getColor() {
        Log.d("TAG","white");
    }

    @Override
    public void say() {

    }

    @Override
    public void eat() {

    }
}
