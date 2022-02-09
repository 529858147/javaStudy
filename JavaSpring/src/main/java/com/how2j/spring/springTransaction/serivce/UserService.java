package com.how2j.spring.springTransaction.serivce;

import com.how2j.spring.springTransaction.bean.User;
import com.how2j.spring.springTransaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:53
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Transactional
    public void addUser(List<User> userList) {
        userMapper.addUser(userList);
    }

    public void deleteUser() {
        userMapper.deleteUser();
    }

    @Transactional
    public int addUserByOne(User user) {
        return userMapper.addUserByOne(user);
    }
}
