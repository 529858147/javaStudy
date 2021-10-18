package com.how2j.container.collection.set;

import java.util.TreeSet;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习TreeSet类
 * 1. TreeSet实际上是TreeMap实现的,是一个有序的集合
 * 2. lower、floor、ceiling 和 higher 分别返回小于、小于等于、大于等于、大于给定元素的元素，如果不存在这样的元素，则返回 null。
 * 3. TreeSet中的元素支持2种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序
 * 4. 比较器Comparator
 * @date 2021/10/18 21:24
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet.add(i);
        }
        System.out.println(treeSet);
        System.out.println(treeSet.ceiling(2));//返回Set中大于/等于e的最小元素
        System.out.println(treeSet.floor(8));//返回Set中小于/等于e的最大元素
        System.out.println(treeSet.lower(5));//返回Set中小于e的最大元素
        TreeSet<Student> set = new TreeSet<>();
        Student s1 = new Student("Tom", 3);
        Student s2 = new Student("Tom", 3);
        Student s3 = new Student("Tim", 4);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set);
    }
}

class Student implements Comparable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object object) {
        Student student = (Student) object;
        if ((student.age - this.age) > 0) {
            return 1;
        } else if ((student.age - this.age) < 0) {
            return -1;
        }
        return 0;
    }

}
