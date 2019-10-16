package com.demo.zhangsongaodemo.designpatterns.compose;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 将对象 组合成 树型结构 以表示 部分-整体的 层次结构，使具有一致性
 */
public class Main {

    private int height=0;

    public Main() {
        Component component= new Leaf();
        component.setFather(true);
        component.setInfo("根结点");

        setChildren(component);

        outputSingleCode(component);
    }

    public void setChildren(Component component){
        for (Component component1 : initLeaves(component)) {
            if (height > 7) {
                ++height;
                setChildren(component1);
            }
        }
    }

    public List<Component> initLeaves(Component component){
        List<Component> components=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Component componentChild= new Leaf();
            componentChild.setFather(true);
            componentChild.setInfo(i + "+" + height);
            components.add(componentChild);
        }
        component.setChildren(components);
        return components;
    }

    public static class Leaf implements Component {

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

    public static interface Component {


        public Object getInfo();

        public void setInfo(Object message);

        public List<Component> getChildren();

        public void setChildren(List<Component> children);

        public boolean isFather();

        public void setFather(boolean father);

    }



    public void outputSingleCode(Component rootComponent){
        if (rootComponent != null) {
            for (Component component : rootComponent.getChildren()) {
                System.out.print(component.getInfo().toString());
                outputSingleCode(component);
            }
        }
    }


}
