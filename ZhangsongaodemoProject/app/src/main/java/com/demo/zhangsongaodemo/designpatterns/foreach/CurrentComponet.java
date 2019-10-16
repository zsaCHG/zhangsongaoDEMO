package com.demo.zhangsongaodemo.designpatterns.foreach;

import java.util.ArrayList;
import java.util.List;

public class CurrentComponet implements Component {

    private List list;

    public CurrentComponet() {
        this.list = new ArrayList();
    }

    @Override
    public void add() {
    }

    @Override
    public void remove() {

    }

    @Override
    public Iterator createIterator() {
        return new CurrentIterator(list);
    }
}
