package com.demo.zhangsongaodemo.designpatterns.agent;

/**
 * Created by zsachg on 2018/10/17.
 */

public class Client {

    public Client() {

        //代理模式
        Subject subject=new RealSubject("data");
        Subject proxy=new Proxy(subject);
        proxy.doWork();


        //普通代理模式
        Subject proxyNormal=new Proxy("data");
        proxyNormal.doWork();


        //透明代理
        Proxy proxyForce = new Proxy();
        Subject subjectForce = new RealSubject(proxyForce);
        proxyForce.doWork();

    }
}
