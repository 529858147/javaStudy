package com.how2j.java.thread.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 1、学习ConcurrentHashMap类的使用
 * 2、在JDK1.7中ConcurrentHashMap使用segment数组，分段锁实现线程安全
 * 3、在JDK1.8中ConcurrentHashMap使用了Node + CAS + Synchronized，实现线程安全
 * @date 2021/8/16 20:41
 */
public class ConcurrentCollectionsDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("str", "str");
        System.out.println(concurrentHashMap.get("str"));

        //使用了ReentrantLock.lock();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("1");
        System.out.println(copyOnWriteArrayList.size());
        copyOnWriteArrayList.add("2");
        System.out.println(copyOnWriteArrayList.size());
        copyOnWriteArrayList.add("3");
        System.out.println(copyOnWriteArrayList.size());
    }
}
