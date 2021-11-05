package com.how2j.thread.basics;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习synchronized的用法
 * @date 2021/8/9 21:35
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String();
        MyService myService = new MyService(lock);
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.start();
        threadB.start();
        System.out.println("执行完毕");
    }
}

class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.doSomeThing();
    }
}

class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.doSomeThing1();
    }
}


/**
 * synchronized可以作用到静态以及非静态方法，代码块上
 * 作用到静态方法，代码块上时，使用的是类锁
 * 作用到非静态方法，代码块上时，使用的是对象锁
 * synchronized可以使用this或者class或者任意对象作为对象监视器
 * synchronized支持锁重入
 * 类锁和对象锁是两个不一样的锁，控制着不同的区域，它们是互不干扰的。同样，线程获得对象锁的同时，也可以获得该类锁，即同时获得两个锁，这是允许的。
 */
class MyService {
    private String lock;
    private int ticket = 10;
    private int count = 10;

    public MyService(String lock) {
        this.lock = lock;
    }


    public static synchronized void say() {
        System.out.println("作用于静态方法,锁是当前class对象");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doSomeThing() {
        while (ticket > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + ",还剩下：" + ticket + "张票");
        }
    }

    public synchronized void doSomeThing1() {
        while (count > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + ", 计数：" + count);
        }
    }
}
