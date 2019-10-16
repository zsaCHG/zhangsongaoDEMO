package com.demo.zhangsongaodemo.designpatterns.Memento;

public class StateSaver {
    private int state;

    public void setState(Component component) {
        this.state = component.getState();
    }
}
