package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.ano.NotAllow;
import com.example.demo.exception.MyException;
import com.example.demo.facade.CarFacade;
import com.example.demo.facade.UserFacade;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : tian
 * @Date : 2018/10/8 15:07
 */
@RestController
public class UserController {


    //@Reference(validation = "userFacade")
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CarFacade carFacade;

    /**
     * Response
     */
    @RequestMapping("user")
    public Response getUser() {
        System.out.println("userFacade is " + userFacade);
        return Response.success(userFacade.getUser());

    }

    @RequestMapping("str")
    public Response getStr(){
        System.out.println("carFacade is "+carFacade);
        return Response.success(carFacade.getStr());
    }

    /**
     * 自定义注解+拦截器
     */
    @RequestMapping("notAllow")
    @NotAllow
    public Response testNotAllow() {
        return Response.success(userFacade.getUser());
    }

    /**
     * 全局捕获异常
     */
    @RequestMapping("exception")
    public Response testException() throws MyException {
        throw new MyException("抛出异常");
    }
}
