package com.how2j.java.container.collection.set;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习HashSet用法
 * 1.HashSet是Set接口的实现类，储存的是无序、唯一的对象
 * 2.实现存储自定义对象时，需要重新hashCode和equals方法
 * @date 2021/10/16 21:54
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println("set: " + set);
        boolean add1 = set.add(1);
        boolean add2 = set.add(20);
        System.out.println(add1);
        System.out.println(add2);
        set.stream().forEach(item -> System.out.println("item: " + item));
        for (Integer i : set) {
            System.out.println(i);
        }
        Student stu1 = new Student("tom", 1);
        Student stu2 = new Student("tom", 1);
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(stu1);
        hashSet.add(stu2);
        System.out.println(hashSet);
    }

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return getAge() == student.getAge() && Objects.equals(getName(), student.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getAge());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
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
    }
}


