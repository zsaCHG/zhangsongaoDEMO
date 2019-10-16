package com.demo.zhangsongaodemo.designpatterns.state;

import android.util.Log;

public class OpenState extends State {


    @Override
    public void open() {

        Log.d("OpenState","OPEN");
    }

    @Override
    public void up() {
        this.context.setCurrentState(this.context.upState);
        this.context.getCurrentState().up();
        Log.d("OpenState","UP");
    }

    @Override
    public void down() {
        Log.d("OpenState","DOWN");
    }

    @Override
    public void stop() {
        Log.d("OpenState","Can,t STOP");
    }
}
