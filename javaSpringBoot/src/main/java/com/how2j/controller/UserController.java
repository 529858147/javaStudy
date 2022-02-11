package com.how2j.controller;

import com.how2j.pojo.User;
import com.how2j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 20:31
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        return userService.queryUserList();
    }
}
