package com.example.demo.controller;

import com.example.demo.utils.Response;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 52613 on 2018/12/18.
 */

@Controller
public class Login {

    @RequestMapping("login")
    public String login(){
        System.out.println("执行登陆方法");
        return "login";
    }


    @ResponseBody
    @RequestMapping("getMajorChart")
    public Response getMajorChart(){

        return Response.success("执行图表成功");
    }

}
