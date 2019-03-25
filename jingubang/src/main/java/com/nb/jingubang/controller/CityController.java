package com.nb.jingubang.controller;

import com.nb.jingubang.entity.City;
import com.nb.jingubang.service.RedisService;
import com.nb.jingubang.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市controller
 */
@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("city")
    public Response test() {
        return Response.success("跳转成功");
    }

    @GetMapping(value = "saveCity")
    public Response saveCity(Long cityId, String cityName, String cityIntroduce) {
        System.out.println("cityId is : " + cityId + " cityName is : " + cityName + " cityIntroduce is : " + cityIntroduce);
        City city = new City(cityId, cityName, cityIntroduce);
        System.out.println("save city is : "+city);
        redisService.set(cityId + "", city);
        return Response.success("redis 保存城市成功！");
    }

    @GetMapping(value = "getCityById")
    public Response getCity(Long cityId) {
        System.out.println("执行getCityById cityId is : " + cityId);
        City city = (City) redisService.get(cityId.toString());

        System.out.println("city is : " + city);
        return Response.success(city);
    }
}
