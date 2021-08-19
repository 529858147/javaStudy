package com.how2j.thread.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/18 21:40
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        RunThread runThread = new RunThread(service);
        //超过线程池大小时，会报拒绝执行错误
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 10, TimeUnit.SECONDS, linkedBlockingQueue);
        for (int i = 0; i < 17; i++) {
            System.out.println("executor: " + executor.getPoolSize());
            executor.submit(runThread);
        }
    }
}

class RunThread implements Runnable {
    private Service service;

    public RunThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Thread Name：" + Thread.currentThread().getName());
        service.doSomeThing();
    }
}

class Service {
    private int count = 0;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void doSomeThing() {
        readWriteLock.readLock().lock();
        for (int i = 0; i < 10; i++) {
            count++;
        }
        readWriteLock.readLock().unlock();
    }
}


