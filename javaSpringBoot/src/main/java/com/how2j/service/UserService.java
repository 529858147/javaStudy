package com.how2j.service;

import com.how2j.pojo.User;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 20:30
 */
public interface UserService {
    User queryUserByName(String name);

    List<User> queryUserList();

    void addUser(List<User> userList);

    void deleteUser();

    int addUserByOne(User user);
}
