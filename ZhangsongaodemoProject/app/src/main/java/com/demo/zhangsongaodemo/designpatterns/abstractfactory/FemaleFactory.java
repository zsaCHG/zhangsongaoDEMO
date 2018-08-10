package com.demo.zhangsongaodemo.designpatterns.abstractfactory;

/**
 * Created by zsachg on 2018/8/9.
 */

public class FemaleFactory implements HumanFactory {

    @Override
    public void createWhite() {
        //new WhiteFemale();
    }

    @Override
    public void createBlack() {
        new BlackFemale();
    }
}
