package com.nb.jingubang.repository;

import com.nb.jingubang.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 城市repository
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
