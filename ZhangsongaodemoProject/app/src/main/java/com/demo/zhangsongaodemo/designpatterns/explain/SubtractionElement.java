package com.demo.zhangsongaodemo.designpatterns.explain;

public class SubtractionElement extends OperationElement {


    public SubtractionElement(Element leftElement, Element rightElement) {
        super(leftElement, rightElement);
    }

    @Override
    public int dealWidthData() {
        return leftElement.dealWidthData() - rightElement.dealWidthData();
    }

}
