package com.demo.zhangsongaodemo.designpatterns.agent;

/**
 * Created by zsachg on 2018/10/17.
 * 被委托者，被代理对象，业务的具体执行对象
 * 真正的游戏玩家账号
 */

public class RealSubject implements Subject {

    @Override
    public void login() {
        //登录
    }

    @Override
    public void trade() {
        //交易
    }

    @Override
    public void play() {
        //游戏
    }

    @Override
    public void doWork() {
        login();
        trade();
        play();
    }


    public RealSubject(String var1){

    }


    /**
     * 普通代理  知道代理的存在 但不知道真正被代理的是什么
     * 情况下 需要代理
     *
     * @param subject 代理对象
     */
    public RealSubject(Subject subject,String var1){

    }

    /**
     * 透明代理
     * （强制的代理）
     * 直接访问了 被代理对象 必须使用代理
     */
    public RealSubject(Proxy subject){
        subject.setSubject(this);
        userProxy = true;
    }

    private boolean userProxy;


    //动态代理 实现阶段不知道被代理的是谁 在运行阶段 才知道

}
