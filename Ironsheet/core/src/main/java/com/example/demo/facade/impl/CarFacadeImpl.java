package com.example.demo.facade.impl;

import com.example.demo.common.User;
import com.example.demo.facade.CarFacade;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: tian
 * 2018/11/11.13:24
 */
@Service
public class CarFacadeImpl implements CarFacade {

    @Override
    public String getStr() {
        System.out.println("执行 str facade");
        return "获取str成功";
    }
}
