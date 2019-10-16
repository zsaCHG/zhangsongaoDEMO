package com.demo.zhangsongaodemo.designpatterns.adapter;

import java.util.Map;

public class OuterData {

    private Map<String,String> userData;

    public Map<String, String> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, String> userData) {
        this.userData = userData;
    }
}
