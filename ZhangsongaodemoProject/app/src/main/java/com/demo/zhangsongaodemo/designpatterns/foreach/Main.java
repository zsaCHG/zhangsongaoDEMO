package com.demo.zhangsongaodemo.designpatterns.foreach;


/**
 * 迭代器 模式
 * 提供了一种方法 访问一个容器对象 里的各个元素 而不保罗 对象内部细节
 */
public class Main {
    public Main() {
        CurrentComponet currentComponet=new CurrentComponet();
        Iterator iterator=currentComponet.createIterator();
        while (iterator.hasNext()) {
            Object object=iterator.next();
        }
    }
}
