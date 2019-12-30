/**
 * @author 周希来
 * @since 2019年5月5日
 */
package com.mywork.frame.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;


/**
 * @author 周希来
 * @since 2019年5月5日
 */
public class JwtUtil {
	public static String TOKEN_SECRE = "zhou";
	public static long TOKEN_TIME = 1000 * 60 * 10;

	/**
	 * 获取token
	 * 
	 * @author 周希来
	 * @since 2019年5月5日
	 * @return
	 *//*
	public static String getToken(User user) {
		user.setPass(null);
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		String token = JWT.create().withHeader(header).withAudience(JSON.toJSONString(user))
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_TIME)).sign(Algorithm.HMAC256(TOKEN_SECRE));

		return token;
	}*/
	/**
	 * 验证token
	 * @author 周希来
	 * @since 2019年5月5日
	 * @param token
	 * @return
	 */
	public static Boolean checkToken(String token) {
		//if(Objects.isNull(token)) return false;
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRE)).build();
		try {
			jwtVerifier.verify(token);
			return true;
		} catch (JWTVerificationException e) {
			return false;
			// throw new RuntimeException("token认证失败");
		}

	}
	/**
	 * 解析token
	 * @author 周希来
	 * @since 2019年5月5日
	 * @param token
	 * @return
	 */
	public static JSONObject getUserByToken(String token) {
		
		return  JSON.parseObject(JWT.decode(token).getAudience().get(0));

	}
	
}
