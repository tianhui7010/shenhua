package com.example.demo;

import com.example.demo.facade.UserFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(WebApplication.class,
				"classpath:/dubbo-consumer.xml");
		application.run(args);
	}
}
