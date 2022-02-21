package com.how2j.spring.springTransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习spring的事务
 * 1、spring中事务可以分为编程式事务控制和声明式事务控制。
 * 2、编程式事务控制：指使用 Conn.setAutoCommit(false); 设置手动控制事务
 * 3、声明式事务控制：Spring声明式事务管理，核心实现就是基于Aop。 Spring声明式事务管理器类：Jdbc技术：DataSourceTransactionManager
 * 4、事务的七种传播行为：
 * PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务，有则用自己的事务。这是最常见的选择。
 * PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起。
 * PROPAGATION_SUPPORTS--如果当前有事务就用当前的，如果当前没有事务就用非事务运行。
 * PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 * PROPAGATION_MANDATORY(强制)--支持当前事务，如果当前没有事务，就抛出异常。
 * PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常。
 * PROPAGATION_NESTED--如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 * @date 2022/1/23 21:55
 */
public class SpringTransactionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springDataSource.xml");
    }
}
