package com.how2j.container.collection.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习ArrayList类的使用
 * @date 2021/10/11 21:23
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        List<Object> list = arrayList.stream().filter((item) -> !Objects.equals(item, 1)).collect(Collectors.toList());
        System.out.println(list);
        boolean allMatch = arrayList.stream().anyMatch(o -> (Objects.equals(o, 9)));
        System.out.println(allMatch);
        Spliterator<Integer> spliterator = arrayList.spliterator();
        Spliterator<Integer> spliterator1 = spliterator.trySplit();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();

        System.out.println("spliterator");
        while (spliterator.tryAdvance(System.out::println)) {

        }
        System.out.println("spliterator1");
        while (spliterator1.tryAdvance(System.out::println)) {

        }
        System.out.println("spliterator2");
        while (spliterator2.tryAdvance(System.out::println)) {

        }


        ListIterator<Integer> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == 2) {
                listIterator.remove();
            }
        }
        System.out.println(arrayList);
    }
}
