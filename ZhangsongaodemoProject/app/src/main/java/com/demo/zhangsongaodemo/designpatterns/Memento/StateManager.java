package com.demo.zhangsongaodemo.designpatterns.Memento;

public class StateManager {

    StateSaver stateSaver;

    public StateSaver getStateSaver() {
        return stateSaver;
    }

    public void setStateSaver(StateSaver stateSaver) {
        this.stateSaver = stateSaver;
    }
}
