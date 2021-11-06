package com.how2j.thread.basics;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
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
        ServicePool servicePool = new ServicePool();
        RunThread runThread = new RunThread(servicePool);
        //超过线程池大小时，会报拒绝执行错误
        BlockingQueue<Runnable> blockingQueue = BlockingQueueEnum.ARRAY_BLOCKING_QUEUE.getBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,//核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
                5,//线程池最大能创建的线程数
                10,//除核心池外的线程，超过核心池数量的线程能存活的时间
                TimeUnit.SECONDS,//存活时间的单位
                blockingQueue,//存放任务的阻塞队列
                new ThreadFactoryTest(),//创建线程的线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy()//当任务数量达到阻塞队列和线程池最大线程数量时，拒绝执行任务的策略
        );
        try {
            for (int i = 0; i < 10; i++) {
                executor.execute(runThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class RunThread implements Runnable {
    private ServicePool servicePool;

    public RunThread(ServicePool servicePool) {
        this.servicePool = servicePool
    }

    @Override
    public void run() {
        servicePool.doSomeThing();
    }
}

class ServicePool {
    private int count = 0;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void doSomeThing() {
        readWriteLock.writeLock().lock();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println("Current Thread Name: " + Thread.currentThread().getName() + ",Count Is: " + count);
        }
        readWriteLock.writeLock().unlock();
    }
}

//自定义线程工厂，实现ThreadFactory接口即可
class ThreadFactoryTest implements ThreadFactory {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        int count = atomicInteger.getAndIncrement();
        Thread thread = new Thread(r);
        thread.setName("pool-" + count + "-Thread-" + count);
        return thread;
    }
}

enum BlockingQueueEnum {
    ARRAY_BLOCKING_QUEUE(new ArrayBlockingQueue(5)),
    LINKED_BLOCKING_QUEUE(new LinkedBlockingQueue(5)),
    PRIORITY_BLOCKING_QUEUE(new PriorityBlockingQueue()),
    DELAY_QUEUE(new DelayQueue()),
    SYNCHRONOUS_QUEUE(new SynchronousQueue()),
    LINKED_TRANSFER_QUEUE(new LinkedTransferQueue()),
    LINKED_BLOCKING_DEQUE(new LinkedBlockingDeque());

    private BlockingQueue<Runnable> blockingQueue;

    BlockingQueueEnum(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public BlockingQueue<Runnable> getBlockingQueue() {
        return blockingQueue;
    }
}
