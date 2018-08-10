package com.demo.zhangsongaodemo.designpatterns.abstractfactory;

/**
 * Created by zsachg on 2018/8/9.
 */

public class MaleFactory implements HumanFactory {


    @Override
    public void createWhite() {
        //new WhiteMale();
    }

    @Override
    public void createBlack() {
        new BlackMale();
    }
}
