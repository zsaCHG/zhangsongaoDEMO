package com.demo.zhangsongaodemo.designpatterns.decorator;

import android.util.Log;

public class Opeator implements BaseOperater {
    @Override
    public void doSomeThing() {
        Log.d("doSomeThing","doSomeThing");
    }
}
