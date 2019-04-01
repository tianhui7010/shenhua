package com.example.demo.common;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/8.
 */
@Component
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6320141401069228466L;
    private String name;
    private String address;
    private Integer age;

}
