package com.nb.jingubang.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.nb.jingubang.service.HelloService;


/**
 * Created by 52613 on 2019/3/7.
 */
@Service(version = "0.0.1")
public class HelloServiceImpl implements HelloService {

    @Override
    public String SayHello(String name) {
        System.out.println("jingubang----------------");
        return "Hello , "+name;
    }

}
