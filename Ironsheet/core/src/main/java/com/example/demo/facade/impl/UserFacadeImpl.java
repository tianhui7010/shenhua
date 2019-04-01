package com.example.demo.facade.impl;


import com.example.demo.common.User;
import com.example.demo.facade.UserFacade;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: tian
 * 2018/10/9.13:49
 */
@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public User getUser() {
        System.out.println("执行facade");
        return userService.getUser();
    }
}
