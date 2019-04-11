package com.nb.wukong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nb.jingubang.repository.condition.CityCondition;
import com.nb.jingubang.service.CityService;
import com.nb.jingubang.utils.Page;
import com.nb.jingubang.utils.Pageable;
import com.nb.wukong.dto.CityDto;
import com.nb.wukong.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nb.jingubang.entity.City;

import java.util.List;

/**
 * 城市controller
 */
@RestController
@RequestMapping("city")
public class CityController {

    @Reference(version = "0.0.1")
    private CityService cityService;

    @GetMapping(value = "save")
    public Response save(String cityName, String cityIntroduce) {
        City city = new City(cityName, cityIntroduce);
        cityService.save(city);
        return Response.success("城市保存成功！");
    }

    //注：修改时必须加id，否则为增加
    @GetMapping(value = "update")
    public Response updateCity(Long id, String cityName, String cityIntroduce) {
        System.out.println("id is :" + id + " cityName is : " + cityName + " cityIntroduce is : " + cityIntroduce);
        City city = new City(id, cityName, cityIntroduce);
        if (cityService.getOne(id) == null) {
            return Response.success("不存在id为：" + id + "的记录！");
        }
        cityService.save(city);
        return Response.success("修改成功！");
    }

    @GetMapping(value = "getById")
    public Response getCityById(Long id) {
        System.out.println("getById id is : " + id);
        City city = (City) cityService.getOne(id);
        return Response.success(city);
    }

    @RequestMapping("listCity")
    public List<City> listCity(CityCondition condition) {
        System.out.println("listCity condition is : " + condition);
        return cityService.getAll(condition);

    }

    @RequestMapping("pageCity")
    public Response pageCity(CityDto dto) {

        System.out.println("pageCity dto is : "+dto);
        CityCondition condition = new CityCondition();
        condition.setId(dto.getId());
        condition.setName(dto.getName());
        Pageable pageable = dto.getPageable();
        System.out.println("pageCity condition is : "+condition+" and pageable is : "+pageable);
        Page<City> cityPage = cityService.getAll(condition, pageable);
        return Response.success(cityPage);

    }

}
