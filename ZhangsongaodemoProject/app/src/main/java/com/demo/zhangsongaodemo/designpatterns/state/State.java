package com.demo.zhangsongaodemo.designpatterns.state;

public abstract class State {

    Context context;

    public State() {
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void up();
    public abstract void down();
    public abstract void stop();
}
