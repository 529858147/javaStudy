package com.how2j.spring.springInit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习spring的初始化
 * @date 2021/11/8 22:28
 */
public class SpringInit {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/springConfig.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(applicationContext.getApplicationName());
    }
}
