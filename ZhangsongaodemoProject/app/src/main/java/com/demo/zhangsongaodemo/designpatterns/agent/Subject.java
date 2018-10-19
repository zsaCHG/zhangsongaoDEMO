package com.demo.zhangsongaodemo.designpatterns.agent;

/**
 * Created by zsachg on 2018/10/17.
 * 最基本的业务需求 依赖抽象
 * 类比：游戏的体系中各个行为
 */

public interface Subject {
    public void login();

    public void trade();

    public void play();

    public void doWork();
}
