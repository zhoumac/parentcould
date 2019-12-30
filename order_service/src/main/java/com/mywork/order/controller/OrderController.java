/**
 * @author 周希来
 * @since 2019年4月25日
 */
package com.mywork.order.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.mywork.frame.stream.service.MessageProvider;
import com.mywork.model.User;
import com.netflix.client.http.HttpRequest;




/**
 * @author 周希来
 * @since 2019年4月25日
 */
@RefreshScope
@RestController
@RequestMapping(value = "/order")
public class OrderController {
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	//@Autowired
	//private MessageProvider messageProvider;
	@Value("${from}")
	private String from;
	
	@PostMapping("/checkToken")
	public String checkToken() {
		
		return "success" ;
	}
	@PostMapping("/hello")
	public String hello(@RequestBody String name) {
		return name;
	}
	@GetMapping("/from")
	public String from( ) {
			User user = new  User();
		user.setIp("1111111");
		user.setName("周希来order");
		user.setId(2);
		
		return from+user.toString() ;
	}
	
	@GetMapping("/send")
	public String send( ) {
		User user = new  User();
		user.setIp("1111111");
		user.setName("周希来order");
		user.setId(2);
		//messageProvider.send(user);
		
		return from+user.toString() ;
	}

	public static void main(String[] args) {
		String str = "^([1-9]?[0-9]{0,11})(\\.?[0-9]{1,3})$";
		System.out.println(Pattern.matches(str, "0.01"));

	}
}
