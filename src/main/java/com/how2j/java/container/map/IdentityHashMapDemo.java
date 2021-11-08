package com.how2j.java.container.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 1. IdentityHashMap类可以存放相同的key
 * 2. 相同指的是只用==比较引用地址，而不是像HashMap一样比较hashcode后再次用equals比较
 * @date 2021/10/21 21:38
 */
public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<Integer, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(1, 1);
        identityHashMap.put(1, 2);
        Integer integer1 = new Integer(129);
        Integer integer2 = new Integer(129);
        identityHashMap.put(integer1, 1);
        identityHashMap.put(integer2, 2);
        System.out.println("identityHashMap: " + identityHashMap);

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(integer1, 1);
        hashMap.put(integer2, 2);
        System.out.println("hashMap: " + hashMap);
    }
}
