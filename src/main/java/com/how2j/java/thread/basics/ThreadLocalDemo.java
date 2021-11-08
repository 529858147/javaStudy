package com.how2j.java.thread.basics;

import java.util.Date;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 1、类ThreadLocal的使用
 * 2、ThreadLocal主要解决的就是每个线程绑定自己的值，可以将ThreadLocal类比喻成全局存放数据的盒子
 * 盒子中可以存储每个线程的私有数据
 * @date 2021/8/12 20:40
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        System.out.println(new Tools().get());
        for (int i = 20; i < 30; i++) {
            Tools.threadLocal.set("Main Set: " + i);
            System.out.println("Main Get:" + Tools.threadLocal.get());
        }
        ThreadG threadG = new ThreadG();
        ThreadH threadH = new ThreadH();
        threadG.start();
        threadH.start();

        Tools2.inheritableThreadLocalExt.set("Main Tools2 Set: " + new Date());
        ThreadI threadI = new ThreadI();
        threadI.start();
        System.out.println("Main Tools2 Get: " + Tools2.inheritableThreadLocalExt.get());
    }
}

class ThreadG extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Tools.threadLocal.set("ThreadG Set: " + i);
            System.out.println("ThreadG Get:" + Tools.threadLocal.get());
        }
    }
}

class ThreadH extends Thread {
    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            Tools.threadLocal.set("ThreadH: " + i);
            System.out.println("ThreadH Get:" + Tools.threadLocal.get());
        }
    }
}

class Tools extends ThreadLocal {
    public static ThreadLocal threadLocal = new ThreadLocal();

    //重写initialValue方法可以让get默认返回任意值
    @Override
    protected Object initialValue() {
        return "default value";
    }
}

/**
 * InheritableThreadLocal类可以让子线程从父线程中取值
 * initialValue()方法初始化get的值
 * childValue()方法能够修改父线程的值
 */
class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return "子线程从父类取值";
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + ", 子线程修改了父线程的值";
    }
}

class Tools2 {
    public static InheritableThreadLocalExt inheritableThreadLocalExt = new InheritableThreadLocalExt();
}

class ThreadI extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadI Get: " + Tools2.inheritableThreadLocalExt.get());
    }
}