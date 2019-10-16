package com.demo.zhangsongaodemo.designpatterns.explain;

public abstract class OperationElement extends Element {

    Element leftElement;
    Element rightElement;

    public OperationElement(Element leftElement, Element rightElement) {
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }
}
