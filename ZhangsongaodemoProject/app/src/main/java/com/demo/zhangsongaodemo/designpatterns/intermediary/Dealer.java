package com.demo.zhangsongaodemo.designpatterns.intermediary;

public abstract class Dealer {
    IntermediaryUtil intermediaryUtil;

    public Dealer(IntermediaryUtil intermediaryUtil) {
        this.intermediaryUtil = intermediaryUtil;
    }

    public abstract void doSelf();
    public abstract void doOuter();
}
