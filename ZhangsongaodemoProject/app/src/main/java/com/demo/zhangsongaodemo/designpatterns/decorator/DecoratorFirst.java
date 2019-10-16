package com.demo.zhangsongaodemo.designpatterns.decorator;

public class DecoratorFirst extends BaseDecorator {


    public DecoratorFirst(BaseOperater lastDecorator) {
        super(lastDecorator);
    }


    private void decoratorFirst(){

    }

    @Override
    public void doSomeThing() {
        decoratorFirst();
        super.doSomething();
    }
}
