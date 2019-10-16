package com.demo.zhangsongaodemo.designpatterns.explain;

public class AddElement extends OperationElement {

    public AddElement(Element leftElement, Element rightElement) {
        super(leftElement, rightElement);
    }

    @Override
    public int dealWidthData() {
        return super.leftElement.dealWidthData()+super.rightElement.dealWidthData();
    }
}
