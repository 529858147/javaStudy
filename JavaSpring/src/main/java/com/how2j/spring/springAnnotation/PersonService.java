package com.how2j.spring.springAnnotation;

import org.springframework.stereotype.Service;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:08
 */
@Service
public class PersonService {
    public void sayHello(){
        System.out.println("hello world");
    }
}
