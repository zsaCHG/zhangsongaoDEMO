package com.demo.zhangsongaodemo.designpatterns.intermediary;

public class DealerFirst extends Dealer {

    public DealerFirst(IntermediaryUtil intermediaryUtil) {
        super(intermediaryUtil);
        intermediaryUtil.setDealerFirst(this);
    }

    public void doSelf(){
        //自身状态更新和修改
    }

    public void doOuter(){
        intermediaryUtil.doSomething();
    }

}
