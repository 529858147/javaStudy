package com.how2j.java.container.collection.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            linkedList.remove();
            System.out.println("listIterator remove: " + linkedList);
        }

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList1.push(i);
        }
        for (int i = 0; i < linkedList1.size(); i++) {//错误用法
            linkedList1.remove();
            System.out.println(linkedList1);
        }
        List<Integer> synchronizedList = Collections.synchronizedList(linkedList);
        synchronizedList.add(1);
    }
}
