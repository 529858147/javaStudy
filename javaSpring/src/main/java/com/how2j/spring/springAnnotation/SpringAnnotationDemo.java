package com.how2j.spring.springAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:06
 */
public class SpringAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAnnotationConfigDemo.class);
        PersonService personService = context.getBean("personService", PersonService.class);
        personService.sayHello();
    }
}
