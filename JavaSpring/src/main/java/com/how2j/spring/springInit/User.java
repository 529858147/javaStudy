package com.how2j.spring.springInit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 22:34
 */
@Component()
@Scope(value = "singleton")
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
}
