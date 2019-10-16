package com.demo.zhangsongaodemo.designpatterns.bridge;

import android.util.Log;

public class ClothesCompany extends Company {

    public ClothesCompany(Crop crop) {
        super(crop);
    }

    @Override
    public void mackMoney() {
        Log.d("Tag","服装赚钱了");
    }
}
