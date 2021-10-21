package com.how2j.container.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 20:51
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false);
        for (int i = 0; i < 10; i++) {
            linkedHashMap.put(i, i);
        }
        linkedHashMap.get(2);
        System.out.println(linkedHashMap);
        //accessOrder入参能把最近访问的元素放到链表后面，搭配重写removeEldestEntry方法可以实现LRU算法
        LinkedHashMap<Integer, Integer> linkedHashMap1 = new LinkedHashMap(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 5;
            }
        };
        for (int i = 0; i < 10; i++) {
            linkedHashMap1.put(i, i);
        }
        System.out.println(linkedHashMap1);
    }
}
