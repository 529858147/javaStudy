package com.how2j.thread.basics;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:实现java多线程有三种方式 1、继承Thread类
 * 2、实现Runnable接口
 * 3、实现Callable接口
 * @date 2021/8/9 20:59
 */
public class ImplementThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadExtend threadExtend = new ThreadExtend();
        threadExtend.start();
        Thread thread = new Thread(new ThreadImpl());
        thread.start();
        FutureTask futureTask = new FutureTask<>(new ThreadImpl2());
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        Object sum = futureTask.get();//get()方法的返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
        System.out.println(sum);
    }
}

class ThreadExtend extends Thread {
    @Override
    public void run() {
        System.out.println("继承了Thread类,当前时间为：" + new Date());
    }
}

class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("实现了Runnable类，当前时间为：" + new Date());
    }
}

/**
 * 相比于run()方法，call()方法可以有返回值
 * call()方法可以抛出异常，被外面的操作捕获，获取异常的信息
 * Callable支持泛型的返回值
 * 需要借助FutureTask类，比如获取返回结果
 * Future接口：
 * 可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
 * FutureTask是Future接口的唯一的实现类。
 * FutureTask同时实现了Runnable、Future接口，它既可以作为Runnable被线程执行，也可以作为Future得到Callable的返回值。
 */
class ThreadImpl2 implements Callable {
    @Override
    public Object call() throws Exception {
        return "实现了Callable类，当前时间为：" + new Date();
    }
}
