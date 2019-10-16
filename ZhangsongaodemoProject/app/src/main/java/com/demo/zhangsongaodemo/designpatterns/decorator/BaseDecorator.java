package com.demo.zhangsongaodemo.designpatterns.decorator;

public abstract class BaseDecorator implements BaseOperater {
    private BaseOperater baseOperater;

    public BaseDecorator(BaseOperater lastDecorator) {
        this.baseOperater = lastDecorator;
    }

    public void doSomething(){
        this.baseOperater.doSomeThing();
    }


}
