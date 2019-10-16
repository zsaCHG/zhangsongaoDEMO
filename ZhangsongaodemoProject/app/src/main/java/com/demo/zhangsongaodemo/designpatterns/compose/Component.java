package com.demo.zhangsongaodemo.designpatterns.compose;

import java.util.List;

public interface Component {


    public Object getInfo();

    public void setInfo(Object message);

    public List<Component> getChildren();

    public void setChildren(List<Component> children);

    public boolean isFather();

    public void setFather(boolean father);

}
