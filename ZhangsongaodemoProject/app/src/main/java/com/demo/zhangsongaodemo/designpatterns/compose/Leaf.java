package com.demo.zhangsongaodemo.designpatterns.compose;

import java.util.ArrayList;
import java.util.List;

public class Leaf implements Component {

    List<Component> children = new ArrayList<>();

    String message;

    private boolean isFather;

    @Override
    public Object getInfo() {
        return message;
    }

    @Override
    public void setInfo(Object message) {
        this.message=String.valueOf(message);
    }

    @Override
    public List<Component> getChildren() {
        if (children == null) {
            return new ArrayList<>();
        }
        return children;
    }

    @Override
    public void setChildren(List<Component> children) {
        this.children = children;
    }

    @Override
    public boolean isFather() {
        return isFather;
    }

    @Override
    public void setFather(boolean father) {
        isFather = father;
    }
}

