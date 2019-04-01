package com.example.demo.repository;

import com.example.demo.common.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/8.
 */
@Component
public class UserRepository {

    public User getUser(){
        User user = new User();
        user.setName("小红");
        user.setAddress("太原");
        user.setAge(23);
        return user;
    }

}
