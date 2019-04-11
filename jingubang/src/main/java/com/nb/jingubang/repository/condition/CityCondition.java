package com.nb.jingubang.repository.condition;

import com.nb.jingubang.frame.ConditionBase;

/**
 * Created by 52613 on 2019/4/3.
 * CityCondition
 */
public class CityCondition extends ConditionBase{

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
