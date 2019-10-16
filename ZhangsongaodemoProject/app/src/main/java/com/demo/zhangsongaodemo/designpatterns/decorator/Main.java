package com.demo.zhangsongaodemo.designpatterns.decorator;

/**
 * 优点：被装饰者 和 装饰者 可以相互独立发展   动态添加功能
 * 场景：给一个类添加功能 动态添加 撤销
 *
 */
public class Main {
    public Main() {

        BaseOperater baseOperater = new Opeator();
        baseOperater = new DecoratorFirst(baseOperater);
        baseOperater = new DecoratorSecond(baseOperater);

        baseOperater.doSomeThing();


    }
}
