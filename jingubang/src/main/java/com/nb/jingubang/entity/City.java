package com.nb.jingubang.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * City
 */
@Entity
@Table(name="th_city")
@Data
public class City extends EntityBase{

    /**城市名**/
    private String name;
    /**介绍**/
    private String introduce;

    public City() {
    }

    public City(String name, String introduce) {
        this.name = name;
        this.introduce = introduce;
    }
    public City(Long id, String name, String introduce) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
