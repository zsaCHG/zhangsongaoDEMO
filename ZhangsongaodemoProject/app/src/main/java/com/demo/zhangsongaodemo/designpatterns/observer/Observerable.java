package com.demo.zhangsongaodemo.designpatterns.observer;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

/**
 * 被观察者
 */
public class Observerable implements ObserverableInterface{

    private List<Observer> observers;

    @Override
    public void addObserver(Object object) {
        if (object instanceof Observer) {
            observers.add((Observer)object);
        }
    }

    @Override
    public void notifyObserver(int key) {
        if (isEnable()) {
            switch (key) {
                case 0:
                    for (Observer observer : observers) {
                        observer.getNotify(new HashMap());
                    }
                    break;
            }
        }
    }

    @Override
    public void deleteObserver(Object object) {

    }

    @Override
    public boolean isEnable() {
        return false;
    }

    public void doSomething(){
        Log.d("Tag","Tag");
        notifyObserver(0);
    }

    public void doSomething(boolean isDoNotify){

    }
}
