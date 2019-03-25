package com.nb.wukong.controller;

import com.nb.wukong.utils.Response;
import com.nb.wukong.utils.anno.PrintTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地点控制器
 */
@RestController
@RequestMapping("place")
public class PlaceController {

    @RequestMapping("testAop")
    public Response testAop(){
        return  Response.SUCCESS;
    }

    @GetMapping("index")
    @PrintTime(param= "PlaceController")
    public Response index(){
        System.out.println("方法执行");
        return Response.success("hello world !");
    }

}
