package com.nb.jingubang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nb.jingubang.entity.SysUser;
import com.nb.jingubang.repository.UserRepository;
import com.nb.jingubang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 52613 on 2019/3/8.
 */
@Service(version = "0.0.1")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SysUser getByUserName(String userName) {
        System.out.println("执行getByUserName");
        return userRepository.getByUserName(userName);
    }
}
