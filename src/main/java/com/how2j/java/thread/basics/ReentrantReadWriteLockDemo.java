package com.how2j.java.thread.basics;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、ReentrantReadWriteLock类具有ReadLock和WriteLock两种锁，持有的锁类型为对象锁
 * 2、读写锁表示有两个锁，一个是读操作相关的锁，也称为共享锁，另一个是写操作相关的锁，也叫做排他锁
 * 3、多个读锁之间不会互斥，但是读锁与写锁互斥，写锁与写锁之间互斥
 * @date 2021/8/13 22:08
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Service service1 = new Service();
        ThreadL threadL = new ThreadL(service);
        ThreadM threadM = new ThreadM(service1);
        threadL.start();
        Thread.sleep(1000);
        threadM.start();
    }
}

class ThreadL extends Thread {
    private Service service;

    public ThreadL(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceA();
    }
}

class ThreadM extends Thread {
    private Service service;

    public ThreadM(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceB();
    }
}

class Service {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private int count = 0;

    public void serviceA() {
        readWriteLock.readLock().lock();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ", Run Service A: " + count);
        }
        readWriteLock.readLock().unlock();
    }

    public void serviceB() {
        readWriteLock.writeLock().lock();
        for (int i = 5; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ", Run Service B: " + count);
        }
        readWriteLock.writeLock().unlock();
    }
}
