package com.how2j.spring.springAnnotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:07
 */
@Aspect
@Component
public class ProxyDemo {
    @Pointcut("execution(* com.how2j.spring.springAnnotation.PersonService.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @After("pointCut()")
    public void afterMethod(){
        System.out.println("afterMethod");
    }
}
