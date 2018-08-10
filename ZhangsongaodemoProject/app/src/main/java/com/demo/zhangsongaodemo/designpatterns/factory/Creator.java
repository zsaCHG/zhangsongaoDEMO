package com.demo.zhangsongaodemo.designpatterns.factory;

/**
 * Created by zsachg on 2018/8/9.
 * 抽象工厂
 */

public abstract class Creator {

    public abstract <T extends Product> T createProduct(Class<T> c);

}
