package com.demo.zhangsongaodemo.designpatterns.order;

public class Worker {
    public void catchOrder(BaseOrder baseOrder){
        baseOrder.doJob();
    }
}
