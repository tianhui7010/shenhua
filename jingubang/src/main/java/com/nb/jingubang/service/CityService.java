package com.nb.jingubang.service;

import com.nb.jingubang.entity.City;

/**
 * Created by 52613 on 2019/3/8.
 */
public interface CityService {

    void save(City city);

    City getOne(Long id);
}
