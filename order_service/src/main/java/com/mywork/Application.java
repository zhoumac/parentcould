package com.mywork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableEurekaClient
@SpringBootApplication
//@EnableCircuitBreaker//开启消息中间件
@EnableAsync//开启异步
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
