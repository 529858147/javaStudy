package com.how2j.thread.basics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:学习ReentrantLock类的使用 1、lock()方法加锁获得对象监视器，unlock()方法解锁
 * 2、使用到的是对象监视器
 * 3、signal()和await()方法相当于notify()和wait()方法,使用前都需要获取对象监视器，否则会报错
 * 4、Condition类可以指定线程唤醒用法为使用lock对象创建多个Condition对象，分别使用condition对方法进行await和signal操作
 * @date 2021/8/12 21:10
 */
public class Thread07 {
    public static void main(String[] args) throws InterruptedException {
        MyServiceReentrant serviceReentrant = new MyServiceReentrant();
        ThreadJ threadJ = new ThreadJ(serviceReentrant);
        threadJ.setName("threadJ");
        ThreadK threadK = new ThreadK(serviceReentrant);
        threadK.setName("ThreadK");

        threadJ.start();
        Thread.sleep(5000);
        serviceReentrant.signalMethodA();

        threadK.start();
        Thread.sleep(5000);
        serviceReentrant.signalMethodB();
    }
}

class ThreadK extends Thread {
    private MyServiceReentrant myServiceReentrant;

    public ThreadK(MyServiceReentrant myServiceReentrant) {
        this.myServiceReentrant = myServiceReentrant;
    }

    @Override
    public void run() {
        myServiceReentrant.serviceB();
    }
}

class ThreadJ extends Thread {
    private MyServiceReentrant myServiceReentrant;

    public ThreadJ(MyServiceReentrant myServiceReentrant) {
        this.myServiceReentrant = myServiceReentrant;
    }

    @Override
    public void run() {
        myServiceReentrant.serviceA();
    }
}

class MyServiceReentrant {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private Condition conditionB = reentrantLock.newCondition();

    public void serviceA() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ", Run ServiceA " + i);
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + ", Run Await");
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void serviceB() {
        try {
            reentrantLock.lock();
            for (int i = 3; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ", Run ServiceB " + i);
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName() + ", Run Await");
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void signalMethodA() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + ", Run Signal Method A");
        conditionA.signal();
        reentrantLock.unlock();
    }

    public void signalMethodB() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + ", Run Signal Method B");
        conditionB.signal();
        reentrantLock.unlock();
    }

}
