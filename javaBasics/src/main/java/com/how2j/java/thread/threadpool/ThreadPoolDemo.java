package com.how2j.java.thread.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/28 21:48
 */
public class ThreadPoolDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        long startTime = System.currentTimeMillis();
        int fileSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(fileSize);
        for (int i = 0; i < fileSize; i++) {
            StringBuffer str = new StringBuffer("str" + i);
            TestService testService = new TestService(str);
            executorService.execute(() -> {
                System.out.println(testService.processData());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("花费了：" + (endTime - startTime) + "ms");
    }
}

class TestService {
    private StringBuffer sb;

    public TestService(StringBuffer sb) {
        this.sb = sb;
    }

    public StringBuffer processData() {
        try {
            Thread.sleep(100);//模拟费时业务流程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sb.append("test");
    }
}