package com.demo.zhangsongaodemo.designpatterns.Memento;

public class Component implements MementoInterface{

    private int state;

    private StateSaver stateSaver;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public void restoreStatus(Object object) {
        setState(((Component)object).getState());
    }

    public StateSaver createStateSaver() {
        if (stateSaver==null) {
            stateSaver=new StateSaver();
        }
        return stateSaver;
    }

}
