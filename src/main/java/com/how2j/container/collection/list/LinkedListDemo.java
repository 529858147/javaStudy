package com.how2j.container.collection.list;

import java.util.LinkedList;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习LinkedList类
 * @date 2021/10/13 20:54
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.push(i);
        }
        System.out.println("peek: " + linkedList.peek());
        System.out.println(linkedList);
        System.out.println("poll: " + linkedList.poll());
        System.out.println(linkedList);
        System.out.println("pollLast: " + linkedList.pollLast());
        System.out.println(linkedList);
        System.out.println("pop: " + linkedList.pop());
        System.out.println(linkedList);
        System.out.println("peekLast: " + linkedList.peekFirst());
        System.out.println(linkedList);
        linkedList.push(11);
        System.out.println("push: " + linkedList);
    }
}
