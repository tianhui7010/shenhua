package com.nb.wukong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nb.jingubang.service.CityService;
import com.nb.wukong.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nb.jingubang.entity.City;

/**
 * 城市controller
 */
@RestController
@RequestMapping("city")
public class CityController {

    @Reference(version = "0.0.1")
    private CityService cityService;

    @GetMapping(value = "save")
    public Response save(String cityName, String cityIntroduce){
        City city = new City(cityName,cityIntroduce);
        cityService.save(city);
        return Response.success("城市保存成功！");
    }

    //注：修改时必须加id，否则为增加
    @GetMapping(value = "update")
    public Response updateCity(Long id,String cityName,String cityIntroduce){
        System.out.println("id is :"+id+" cityName is : "+cityName+" cityIntroduce is : "+cityIntroduce);
        City city = new City(id,cityName,cityIntroduce);
        cityService.save(city);
        return Response.success("修改成功！");
    }

    @GetMapping(value = "getById")
    public Response getCityById(Long id){
        City city = cityService.getOne(id);
        return Response.success(city);
    }

}
