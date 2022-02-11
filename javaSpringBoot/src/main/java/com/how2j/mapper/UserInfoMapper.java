package com.how2j.mapper;

import com.how2j.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 20:27
 */
@Mapper
public interface UserInfoMapper {
    User queryUserByName(String name);

    List<User> queryUserList();

    void addUser(List<User> userList);

    void deleteUser();

    int addUserByOne(User user);
}
