package com.how2j.container.collection.set;

import java.util.LinkedHashSet;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/19 20:52
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < 10; i++) {
            linkedHashSet.add(i);
        }
        System.out.println(linkedHashSet);

    }
}
