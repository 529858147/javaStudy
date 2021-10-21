package com.how2j.container.map;

import java.util.TreeMap;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: TreeMap的使用
 * 1. TreeMap默认按照key的大小对key进行升序排序
 * 2. 基于红黑树实现的排序Map
 * @date 2021/10/21 21:15
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put((int) (Math.random() * 10), (int) (Math.random() * 10));
        }
        System.out.println(treeMap);
        Integer ceilingKey = treeMap.ceilingKey(1);
        System.out.println(ceilingKey);
    }
}
