package com.demo.zhangsongaodemo.designpatterns.dutychain;

public abstract class BaseChain {

    private BaseChain nextChain;

    private int level;

    public BaseChain(int level) {
        this.level = level;
    }

    public void dealWith(int level){
        if(this.level == level){
            doThing();
        }else {
            if (nextChain != null) {
                nextChain.dealWith(level);
            }
        }
    }

    public void setNextChain(BaseChain baseChain){
        this.nextChain=baseChain;
    }

    public abstract void doThing();

}
