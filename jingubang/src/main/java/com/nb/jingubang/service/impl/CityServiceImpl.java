package com.nb.jingubang.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.nb.jingubang.entity.City;
import com.nb.jingubang.repository.CityRepository;
import com.nb.jingubang.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 52613 on 2019/3/8.
 */
@Service(version = "0.0.1")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getOne(Long id) {
        return cityRepository.findOne(id);
    }

}
