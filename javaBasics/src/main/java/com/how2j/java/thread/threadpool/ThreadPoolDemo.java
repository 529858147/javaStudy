package com.how2j.java.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/28 21:48
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        List<Future<StringBuffer>> resultList = new ArrayList<Future<StringBuffer>>();
        long startTime = System.currentTimeMillis();
        int fileSize = 100;
        for (int i = 0; i < fileSize; i++) {
            StringBuffer str = new StringBuffer("str" + i);
            TestService testService = new TestService(str);
            Future<StringBuffer> future = executorService.submit(() -> testService.processData());
            resultList.add(future);
        }
        for (Future<StringBuffer> future : resultList) {
            while (true) {
                if (future.isDone()) {
                    System.out.println(future.get() + "," + future.isDone());
                    break;
                }
            }
        }
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
        StringBuffer test = sb.append("test");
        //System.out.println(test);
        return test;
    }
}