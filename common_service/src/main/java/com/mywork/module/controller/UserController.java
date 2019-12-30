/**
 * @author 周希来
 * @since 2019年4月25日
 */
package com.mywork.module.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpRequest;
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
import com.mywork.frame.eventManger.UserEvent;
import com.mywork.frame.util.IPUtils;
import com.mywork.frame.util.JwtUtil;
import com.mywork.model.User;


/**
 * @author 周希来
 * @since 2019年4月25日
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher ;
	@Value("${from}")
	private String from;
	
	@GetMapping("/getUser")
	public String getUser() {
		applicationEventPublisher.publishEvent(new UserEvent("事件") );
		return "hello user";
	}
	@GetMapping("/getUserDetail")
	public String getUserDetail() {
		applicationEventPublisher.publishEvent(new UserEvent("事件") );
		return "hello user detail";
	}
	@PostMapping("/login")
	public String login(@RequestBody User user,HttpServletRequest request) {
		//登陆生成token并缓存在redis
		String token = JwtUtil.getToken(user);	
		user.setId(1);
		user.setIp(IPUtils.getIpAddr(request));
		user.setUserAgent(IPUtils.getUserAgent(request));
		//redisTemplate.opsForValue().set(token, JSON.toJSONString(user)  ,  60*10,TimeUnit.SECONDS);
		return token ;
	}
	@PostMapping("/checkToken")
	public String checkToken() {
		
		return "success" ;
	}
	
	@GetMapping("/from")
	public String from() {
			User user = new  User();
		user.setIp("1111111");
		user.setName("周希来");
		user.setId(1);
		
		return from+user.toString() ;
	}
}
