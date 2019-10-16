package com.demo.zhangsongaodemo.designpatterns.explain;

public class NumberElement extends Element {

    private int selfValue;

    public NumberElement(int selfValue) {
        this.selfValue = selfValue;
    }

    @Override
    public int dealWidthData() {
        return selfValue;
    }
}
