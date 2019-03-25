package com.nb.jingubang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 城市
 */
@Entity
@Table(name="th_city")
@Data
public class City implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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


}
