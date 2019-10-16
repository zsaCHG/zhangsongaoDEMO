package com.demo.zhangsongaodemo.designpatterns.observer;

public interface ObserverableInterface {

    public void addObserver(Object object);

    public void notifyObserver(int key);

    public void deleteObserver(Object object);

    public boolean isEnable();

}
