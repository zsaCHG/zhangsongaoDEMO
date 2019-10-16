package com.demo.zhangsongaodemo.designpatterns.bridge;

import android.util.Log;

public class ClothesCrop implements Crop {

    @Override
    public void beProduct() {
        Log.d("Tag","生产衣服");
    }

    @Override
    public void beSell() {
        Log.d("Tag","卖衣服");
    }
}
