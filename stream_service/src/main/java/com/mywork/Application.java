package com.mywork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCircuitBreaker//开启消息中间件
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
