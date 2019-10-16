package com.demo.zhangsongaodemo.designpatterns.order;


/**
 * 命令的抽象
 * 所有的命令 都要服从这个
 */
public abstract class BaseOrder {

    /**
     * 所有命令 服从的参数
     * 操作这个参数
     */
    public String params;

    public abstract void doJob();

}
