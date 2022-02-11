package com.how2j.service.impl;

import com.how2j.mapper.UserInfoMapper;
import com.how2j.pojo.User;
import com.how2j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 20:31
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User queryUserByName(String name) {
        return null;
    }

    @Override
    public List<User> queryUserList() {
        return userInfoMapper.queryUserList();
    }

    @Override
    public void addUser(List<User> userList) {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public int addUserByOne(User user) {
        return 0;
    }
}
