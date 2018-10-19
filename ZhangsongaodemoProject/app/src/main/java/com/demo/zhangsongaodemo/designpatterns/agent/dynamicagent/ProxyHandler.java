package com.demo.zhangsongaodemo.designpatterns.agent.dynamicagent;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zsachg on 2018/10/17.
 * 动态代理 处理器
 */

public class ProxyHandler implements InvocationHandler {

    private static final String TAG="ProxyHandler";

    private Object subject;

    public ProxyHandler( Object subject )
    {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equalsIgnoreCase("dowork")) {
            //执行 前置方法
            Log.d(TAG,"pay");
        }
        return method.invoke( subject, args);
    }
}
