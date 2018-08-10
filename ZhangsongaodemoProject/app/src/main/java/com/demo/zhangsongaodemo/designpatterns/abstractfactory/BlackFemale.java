package com.demo.zhangsongaodemo.designpatterns.abstractfactory;

import android.util.Log;

/**
 * Created by zsachg on 2018/8/9.
 */

public class BlackFemale extends AbstractBlackHuman{

    @Override
    public void getSex() {
        Log.d("sex","female");
    }
}
