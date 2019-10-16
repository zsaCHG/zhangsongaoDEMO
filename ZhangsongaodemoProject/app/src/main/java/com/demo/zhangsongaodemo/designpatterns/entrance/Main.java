package com.demo.zhangsongaodemo.designpatterns.entrance;

/**
 * 门面模式
 * 类似二次封装
 */
public class Main {
    public Main() {
        Entrance entrance=new Entrance();
        entrance.doA();
        entrance.doB();

        entrance.submit();
    }
}
