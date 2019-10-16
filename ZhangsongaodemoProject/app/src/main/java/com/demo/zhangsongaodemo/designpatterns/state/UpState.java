package com.demo.zhangsongaodemo.designpatterns.state;

import android.util.Log;

public class UpState extends State {

    @Override
    public void open() {

    }

    @Override
    public void up() {
        Log.d("OpenState","OPEN");
    }

    @Override
    public void down() {

    }

    @Override
    public void stop() {
        Log.d("OpenState","STOP");
    }
}
