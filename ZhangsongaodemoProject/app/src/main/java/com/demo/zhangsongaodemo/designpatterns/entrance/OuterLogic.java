package com.demo.zhangsongaodemo.designpatterns.entrance;

public class OuterLogic {
    public void submit(Operator operator){
        operator.A();
        operator.B();
    }
}
