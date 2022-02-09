package com.how2j.spring.springTransaction.serivce;


import com.how2j.spring.springTransaction.bean.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/6 17:23
 */

public class UserServiceTest {
    static UserService userService;

    @BeforeClass
    public static void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/springDataSource.xml");
        userService = ctx.getBean(UserService.class);
    }

    @Test
    public void testQueryUserByName() {
        User user = userService.queryUserByName("Tom");
        Assert.assertNotNull(user);
    }

    @Test
    public void testQueryUserList() {
        List<User> userList = userService.queryUserList();
        System.out.println(userList);
    }

    @Test
    public void testAddUser() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user = new User(i, "name:" + i, i, "position:" + i, "address:" + i, "roleName:" + i);
            list.add(user);
        }
        userService.addUser(list);
    }

    @Test
    public void testAddUserByOne() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //CountDownLatch countDownLatch = new CountDownLatch(100);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            int number = i;
            poolExecutor.execute(() -> {
                System.out.println("number======================>" + number);
                User user = new User(number, "name:" + number, number, "position:" + number, "address:" + number, "roleName:" + number);
                userService.addUserByOne(user);
                //countDownLatch.countDown();
            });
        }
        //countDownLatch.await();
//        for (int i = 0; i < 100; i++) {
//            int number = i;
//            User user = new User(number, "name:" + number, number, "position:" + number, "address:" + number, "roleName:" + number);
//            userService.addUserByOne(user);
//        }
        Thread.sleep(20000);
        long endTime = System.currentTimeMillis();
        long spendTime = (endTime - startTime) / 1000;
        System.out.println("创建花费时间为：" + spendTime);
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser();
    }
}