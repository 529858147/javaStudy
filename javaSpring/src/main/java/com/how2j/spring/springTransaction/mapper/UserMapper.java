package com.how2j.spring.springTransaction.mapper;

import com.how2j.spring.springTransaction.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 21:45
 */
@Mapper
public interface UserMapper {
    User queryUserByName(String name);

    List<User> queryUserList();

    void addUser(List<User> userList);

    void deleteUser();

    int addUserByOne(User user);
}
