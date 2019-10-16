package com.demo.zhangsongaodemo.designpatterns.entrance;

public class Entrance {

    /**
     * 实际的操作者
     */
    Operator operator;


    /**
     * 外部逻辑封装  门面类不涉及逻辑
     */
    OuterLogic outerLogic;

    public Entrance() {
        this.operator = new Operator();
    }

    public void doA(){
        operator.A();
    }

    public void doB(){
        operator.B();
    }


    public void submit(){
        getOuterLogic().submit(operator);
    }

    public OuterLogic getOuterLogic(){
        if (outerLogic == null) {
            outerLogic=new OuterLogic();
        }
        return outerLogic;
    }
}
