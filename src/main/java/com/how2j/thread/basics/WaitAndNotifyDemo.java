package com.how2j.thread.basics;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、使用wait和notify模拟生产者消费者
 * 2、wait方法会释放持有的锁，并且线程对象会进入线程等待池，等待被唤醒
 * 3、notify方法会随机对一个线程进行唤醒，并且开始竞争锁，唤醒的线程获得锁之后，到执行结束后才会释放锁
 * @date 2021/8/10 21:18
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        String lock = new String();
        P p = new P(lock);
        C c = new C(lock);
        ThreadE e = new ThreadE(p);
        ThreadF f = new ThreadF(c);
        e.start();
        f.start();
    }
}

class ThreadE extends Thread {
    private P p;

    public ThreadE(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.p();
        }
    }
}

class ThreadF extends Thread {
    private C c;

    public ThreadF(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.c();
        }
    }
}

class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void c() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    System.out.println("等待生产者，生产食物");
                    lock.wait();
                }
                System.out.println("消费者：" + Thread.currentThread().getName() + ",消费了一份食物: " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void p() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    System.out.println("等待消费者，消费食物");
                    lock.wait();
                }
                ValueObject.value = "food";
                System.out.println("生产者："+Thread.currentThread().getName() + ",生成了一份食物: " + ValueObject.value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ValueObject {
    public static String value = "";
}

