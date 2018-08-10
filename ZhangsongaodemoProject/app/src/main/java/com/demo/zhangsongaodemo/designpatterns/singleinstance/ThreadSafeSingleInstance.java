package com.demo.zhangsongaodemo.designpatterns.singleinstance;

/**
 * Created by zsachg on 2018/8/9.
 * 线程安全的单例模式
 * 1 双检索
 * 2 内部类
 */

public class ThreadSafeSingleInstance {

    private ThreadSafeSingleInstance resource = null;
    public ThreadSafeSingleInstance getResource() {
        if (resource == null) {
            synchronized(ThreadSafeSingleInstance.class){
                if (resource == null)
                    resource = new ThreadSafeSingleInstance();
            }
        }
        return resource;
    }


    private static class InnerThreadSafeSingleInstance{
        public static ThreadSafeSingleInstance threadSafeSingleInstance=new ThreadSafeSingleInstance();
    }

    public ThreadSafeSingleInstance getSingleInstance(){
        return InnerThreadSafeSingleInstance.threadSafeSingleInstance;
    }

}
