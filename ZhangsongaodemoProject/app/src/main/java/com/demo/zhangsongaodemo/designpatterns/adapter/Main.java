package com.demo.zhangsongaodemo.designpatterns.adapter;

public class Main {
    public Main() {
        //取到对方数据
        OuterData outerData=new OuterData();

        TransitData transitData=new TransitData(outerData);

        transitData.getAddress();

        transitData.getPhoneNum();

    }
}
