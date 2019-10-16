package com.demo.zhangsongaodemo.designpatterns.intermediary;

public class Main {
    /**
     * 操作类 必须依赖中介者
     * 中介者不依赖 操纵类
     *
     * 操作者之间的交互 都是在中介者里  没有显式的交互
     */
    public Main() {
        IntermediaryUtil intermediaryUtil=new IntermediaryUtil();

        DealerFirst dealerFirst=new DealerFirst(intermediaryUtil);
        DealerSecond dealerSecond=new DealerSecond(intermediaryUtil);

        dealerFirst.doOuter();
        dealerSecond.doOuter();
    }
}
