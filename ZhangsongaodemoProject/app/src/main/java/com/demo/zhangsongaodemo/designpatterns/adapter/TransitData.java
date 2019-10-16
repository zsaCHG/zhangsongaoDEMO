package com.demo.zhangsongaodemo.designpatterns.adapter;

public class TransitData extends OuterData implements UserInterface{

    private OuterData outerData;

    public TransitData(OuterData outerData) {
        this.outerData=outerData;
    }

    @Override
    public int getUserId() {
        return Integer.valueOf(outerData.getUserData().get("key"));
    }

    @Override
    public String getUserName() {
        return String.valueOf(outerData.getUserData().get("key"));
    }

    @Override
    public String getPhoneNum() {
        return String.valueOf(outerData.getUserData().get("key"));
    }


    @Override
    public String getAddress() {
        return String.valueOf(outerData.getUserData().get("key"));
    }

}
