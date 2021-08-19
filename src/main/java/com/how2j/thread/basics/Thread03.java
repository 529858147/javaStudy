package com.how2j.thread.basics;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 1、volatile关键字能使被修饰的变量对所有线程可见，属于线程同步的轻量级实现方法
 * 2、volatile不能保证原子性
 * 3、和synchronized区别为，synchronized可以保证可见性和原子性，并且会阻塞线程
 * @date 2021/8/10 20:35
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        ThreadC threadC = new ThreadC();
        new Thread(threadC).start();
        Thread.sleep(1000);
        threadC.setFlag(false);

        //证明volatile不具备原子性的特点，以下结果应该是10000
        ThreadD[] threadDS = new ThreadD[100];
        for (int i = 0; i < 100; i++) {
            threadDS[i] = new ThreadD();
        }
        for (int i = 0; i < threadDS.length; i++) {
            threadDS[i].start();
        }
    }
}

class ThreadC implements Runnable {
    private volatile boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        doSomeThing();
    }

    public void doSomeThing() {
        System.out.println("进入了doSomeThing方法");
        while (flag) {
        }
        System.out.println(Thread.currentThread().getName() + " ,线程被停止");
    }
}

class ThreadD extends Thread {
    private volatile static int count = 0;

    public static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count: " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}