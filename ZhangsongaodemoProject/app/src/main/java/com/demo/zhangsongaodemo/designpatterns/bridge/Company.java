package com.demo.zhangsongaodemo.designpatterns.bridge;

public abstract class Company {
    protected Crop crop;

    public Company(Crop crop) {
        this.crop = crop;
    }

    public abstract void mackMoney();

    public void produce(){
        crop.beProduct();
        crop.beSell();
        mackMoney();
    }

}
