package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: tian
 * 2018/11/4.0:21
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CoreApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(CoreApplication.class,
                "classpath:/dubbo-provider.xml");
        application.run(args);

    }
}
