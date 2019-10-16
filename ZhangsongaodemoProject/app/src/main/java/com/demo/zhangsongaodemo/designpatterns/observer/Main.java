package com.demo.zhangsongaodemo.designpatterns.observer;

public class Main {
    public Main() {
        Observer observer=new FirstObserver();

        Observerable observerable=new Observerable();
        observerable.addObserver(observer);

        observerable.doSomething();
    }
}
