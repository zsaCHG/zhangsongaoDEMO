package com.demo.zhangsongaodemo.designpatterns.order;

/**
 * 命令模式
 * 故名思后就是 命令
 * 类似领导 发布命令 不管底层的员工到底怎么做的
 * 只知道命令的本身
 *
 * 本质是  把请求转换成 对象
 */
public class Main {
    public Main() {
        BaseOrder baseOrder=new FirstOrder();
        Worker worker=new Worker();
        worker.catchOrder(baseOrder);
    }
}
