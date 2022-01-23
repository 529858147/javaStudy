package com.how2j.spring.springXmlConfig;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 22:34
 */
public class User {
    private String name;
    private int age;

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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void printUserInfo() {
        System.out.println(this.toString());
    }
}
