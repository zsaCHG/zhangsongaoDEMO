package com.demo.zhangsongaodemo.designpatterns.agent;

/**
 * Created by zsachg on 2018/10/17.
 * 代理类 对被代理的应用 限制执行  并可增加前后执行的处理
 * 工作室代理角色
 */

public class Proxy implements Subject{

    /**
     * 被代理的对象
     */
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void login() {

    }

    @Override
    public void trade() {

    }

    @Override
    public void play() {

    }

    public void doWork(){
        if(canWork()&&subject!=null){
            before();
            subject.doWork();
            after();
        }
    }

    /**
     * 结束工作
     */
    private void after(){

    }

    /**
     * 执行准备工作
     */
    private void before(){

    }

    private boolean canWork(){
        return true;
    }


    /**
     * 普通代理
     * 隐藏了真是的代理角色 解耦 接口约束
     */
    public Proxy(String var1) {
        this.subject = new RealSubject(this,var1);
    }

    public Proxy() {
    }

    /**
     * 设置被代理角色
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
