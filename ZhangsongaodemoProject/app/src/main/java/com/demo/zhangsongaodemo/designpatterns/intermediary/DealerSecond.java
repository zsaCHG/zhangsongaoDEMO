package com.demo.zhangsongaodemo.designpatterns.intermediary;

public class DealerSecond extends Dealer {


    public DealerSecond(IntermediaryUtil intermediaryUtil) {
        super(intermediaryUtil);
        intermediaryUtil.setDealerSecond(this);
    }

    public void doSelf(){
        //自身状态更新和修改
    }

    public void doOuter(){
        //中介负责
        intermediaryUtil.doSomething();
    }
}
