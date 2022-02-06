package com.how2j.spring.springTransaction.serivce;


import com.how2j.spring.springTransaction.bean.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
            User user = new User("name:" + i, i);
            list.add(user);
        }
        userService.addUser(list);
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser();
    }
}