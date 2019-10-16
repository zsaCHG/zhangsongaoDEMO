package com.demo.zhangsongaodemo.designpatterns.state;

/**
 * 状态 模式
 * 每个状态是相互依赖的 相互依存的  有前置关系
 * 转台封装 管理 context
 * 状态实现类 实现自己的状态 和 各个迁移下的操作
 */
public class Main {

    public Main() {
        OpenState openState=new OpenState();
        Context context=new Context(openState);
        context.stop();
    }

}
