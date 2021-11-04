package com.how2j.thread.basics;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、使用锁实现多线程场景下的单例模式
 * 2、懒汉式单例模式: 多线程调用下，存在线程安全问题
 * 3、饿汉式单例模式: 饿汉式是在类加载的时候创建实例,所以线程是安全的
 * @date 2021/8/14 15:07
 */
public class SingletonByThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadN[] ns = new ThreadN[20];
        for (int i = 0; i < ns.length; i++) {
            ns[i] = new ThreadN();
        }
        for (int i = 0; i < ns.length; i++) {
            ns[i].start();
            ns[i].join();
        }
        System.out.println("==========================================");
        ThreadO[] os = new ThreadO[20];
        for (int i = 0; i < os.length; i++) {
            os[i] = new ThreadO();
        }
        for (int i = 0; i < os.length; i++) {
            os[i].start();
        }

    }
}

class ThreadN extends Thread {
    @Override
    public void run() {
        Object instance = SingletonA.getInstance();
        System.out.println("Lazy Create Object: " + instance.hashCode());
    }
}

class ThreadO extends Thread {
    @Override
    public void run() {
        Object instance = SingletonB.getInstance();
        System.out.println("Now Create Object: " + instance.hashCode());
    }
}

class SingletonA {
    private volatile static Object obj;

    public static Object getInstance() {
        if (obj == null) {
            synchronized (SingletonA.class) {
                if (obj == null) {
                    obj = new Object();
                }
            }
        }
        return obj;
    }
}

class SingletonB {
    private static Object obj = new Object();

    private SingletonB() {
    }

    public static Object getInstance() {
        return obj;
    }
}
