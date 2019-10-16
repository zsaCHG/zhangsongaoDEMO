package com.demo.zhangsongaodemo.designpatterns.observer;

import java.util.Map;

public class FirstObserver implements Observer {

    @Override
    public void getNotify(Map notifyData) {
        if (isCatch(notifyData)) {

        }
    }

    @Override
    public boolean isCatch(Map notifyData) {
        return false;
    }
}
