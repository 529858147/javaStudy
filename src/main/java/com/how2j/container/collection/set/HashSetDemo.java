package com.how2j.container.collection.set;

import java.util.HashSet;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习HashSet用法
 * 1、HashSet是Set接口的实现类，储存的是无序、唯一的对象
 * @date 2021/10/16 21:54
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println("set: " + set);
        boolean add1 = set.add(1);
        boolean add2 = set.add(20);
        System.out.println(add1);
        System.out.println(add2);
        set.stream().forEach(item -> System.out.println("item: " + item));
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
