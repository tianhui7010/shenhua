package com.nb.wukong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nb.jingubang.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by 52613 on 2019/3/7.
 */
@RestController
public class HelloController {

    @Reference(version = "0.0.1")
    private HelloService helloService ;

    @GetMapping("sayHello")
    public String sayHello(String name){
        System.out.println("helloService is : "+helloService);
        name ="小红";
        return helloService.SayHello(name);
    }
}
