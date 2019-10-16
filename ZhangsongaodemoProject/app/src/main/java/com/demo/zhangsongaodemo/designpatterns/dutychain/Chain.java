package com.demo.zhangsongaodemo.designpatterns.dutychain;

public class Chain {

    BaseChain chain;

    public Chain() {
        FirstChain firstChain=new FirstChain(0);
        SecondChain secondChain=new SecondChain(1);
        firstChain.setNextChain(secondChain);
        secondChain.setNextChain(null);
    }

    public void go(Event event){
        chain.dealWith(event.level);
    }
}
