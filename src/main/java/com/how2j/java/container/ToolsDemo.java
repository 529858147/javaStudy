package com.how2j.java.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 22:01
 */
public class ToolsDemo {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "d", "e"};
        List list = new ArrayList(Arrays.asList(str));
        System.out.println("asList: " + list);
        Comparable max = Collections.max(list);
        System.out.println("max: " + max);
        Collections.shuffle(list);
        System.out.println("shuffle: " + list);
        Collections.sort(list);
        System.out.println("sort: " + list);
        System.out.println("binarySearch: " + Collections.binarySearch(list, "c"));
    }
}
