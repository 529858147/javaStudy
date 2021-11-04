package com.how2j.thread.basics;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
 * 2、在Daemon线程中产生的新线程也是Daemon的。
 * @date 2021/8/15 20:07
 */
public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Thread.sleep(1000);
                            System.out.println("Thread 1 Run");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            @Override
            public void run() {
                thread.setDaemon(true);
                thread.start();
                System.out.println("Thread 2 Run Out");
            }
        });
        thread1.start();
        Thread.sleep(10000);
        System.out.println("Main Run Out");
    }
}
