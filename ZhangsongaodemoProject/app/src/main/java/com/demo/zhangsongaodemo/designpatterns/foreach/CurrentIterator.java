package com.demo.zhangsongaodemo.designpatterns.foreach;

import java.util.List;

public class CurrentIterator implements Iterator{

    private List list;

    public CurrentIterator(List list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean remove() {
        return false;
    }
}
