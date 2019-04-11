package com.nb.jingubang.controller;

import com.nb.jingubang.entity.City;
import com.nb.jingubang.repository.condition.CityCondition;
import com.nb.jingubang.service.CityService;
import com.nb.jingubang.service.RedisService;
import com.nb.jingubang.utils.Page;
import com.nb.jingubang.utils.Pageable;
import com.nb.jingubang.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市controller
 */
@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CityService cityService;

    @RequestMapping("city")
    public Response test() {
        return Response.success( "跳转成功" );
    }

    @GetMapping(value = "saveCity")
    public Response saveCity(Long cityId, String cityName, String cityIntroduce) {
        System.out.println( "cityId is : " + cityId + " cityName is : " + cityName + " cityIntroduce is : " + cityIntroduce );
        City city = new City( cityId, cityName, cityIntroduce );
        System.out.println( "save city is : " + city );
        redisService.set( cityId + "", city );
        return Response.success( "redis 保存城市成功！" );
    }

    @GetMapping(value = "getCityById")
    public Response getCity(Long cityId) {
        System.out.println( "执行getCityById cityId is : " + cityId );
        City city = (City) redisService.get( cityId.toString() );

        System.out.println( "city is : " + city );
        return Response.success( city );
    }

    @RequestMapping("listCity")
    public List<City> listCity(CityCondition condition) {
        System.out.println( "pageQuery condition is : " + condition );
        return cityService.getAll( condition );

    }

    @RequestMapping("pageCity")
    public Page<City> pageCity(CityCondition condition,Pageable pageable) {

        return cityService.getAll( condition, pageable );

    }

}
