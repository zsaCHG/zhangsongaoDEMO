package com.demo.zhangsongaodemo.designpatterns.Memento;

public class Main {
    public Main() {
        Component component=new Component();


        StateManager stateManager=new StateManager();
        stateManager.setStateSaver(component.createStateSaver());

        component.setState(-1);

        component.restoreStatus(stateManager.getStateSaver());

    }
}
