package com.demo.zhangsongaodemo.designpatterns.decorator;

public class DecoratorSecond extends BaseDecorator {


    public DecoratorSecond(BaseOperater baseOperater) {
        super(baseOperater);
    }

    private void decoratorSecond(){

    }

    @Override
    public void doSomeThing() {
        super.doSomething();
        decoratorSecond();
    }
}
