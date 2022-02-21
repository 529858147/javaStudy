package com.how2j.spring.springAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:06
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.how2j.spring.springAnnotation")
public class SpringAnnotationConfigDemo {
}
