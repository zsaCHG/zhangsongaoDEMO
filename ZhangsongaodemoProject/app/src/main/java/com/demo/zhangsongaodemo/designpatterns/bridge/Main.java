package com.demo.zhangsongaodemo.designpatterns.bridge;

/**
 * 桥梁模式
 */
public class Main {
    public Main() {
        Crop crop=new ClothesCrop();
        ClothesCompany clothesCompany=new ClothesCompany(crop);
        clothesCompany.produce();
    }
}
