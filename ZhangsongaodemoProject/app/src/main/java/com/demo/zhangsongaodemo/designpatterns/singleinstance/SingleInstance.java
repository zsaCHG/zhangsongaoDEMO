package com.demo.zhangsongaodemo.designpatterns.singleinstance;

/**
 * Created by zsachg on 2018/8/9.
 * 最简单的单例模式 线程不安全
 */

public class SingleInstance {
    private static SingleInstance instance;
    private SingleInstance(){}
    public static SingleInstance getInstance(){
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }
}
