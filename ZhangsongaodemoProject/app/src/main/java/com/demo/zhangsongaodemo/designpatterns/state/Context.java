package com.demo.zhangsongaodemo.designpatterns.state;

public class Context{

    protected OpenState openState = new OpenState();
    protected UpState upState = new UpState();

    private State currentState;

    public Context(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void open() {
        currentState.open();
    }

    public void up() {
        currentState.up();
    }

    public void down() {
        currentState.down();
    }

    public void stop() {
        currentState.stop();
    }
}
