package com.demo.zhangsongaodemo.designpatterns.agent.dynamicagent;

import com.demo.zhangsongaodemo.designpatterns.agent.RealSubject;
import com.demo.zhangsongaodemo.designpatterns.agent.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by zsachg on 2018/10/17.
 */

public class Client {

    public Client() {
        Subject subject=new RealSubject("");

        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new ProxyHandler(subject));

        proxySubject.doWork();
    }
}
