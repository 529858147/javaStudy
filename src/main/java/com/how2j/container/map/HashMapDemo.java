package com.how2j.container.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 20:17
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map);
        //此种方式遍历map的key和value效率最高
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        map.entrySet().iterator().forEachRemaining(integerIntegerEntry -> System.out.println("integerIntegerEntry: " + integerIntegerEntry));
    }
}
