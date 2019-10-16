package com.demo.zhangsongaodemo.designpatterns.observer;

import java.util.Map;

/**
 * 观察者
 */
public interface Observer {
    public void getNotify(Map notifyData);

    public boolean isCatch(Map notifyData);
}
