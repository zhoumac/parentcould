/**
 * @author 周希来
 * @since 2019年5月5日
 */
package com.mywork.frame.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mywork.model.User;

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
	 */
	public static String getToken(User user) {
		User userPlus =  new User();
		userPlus.setId(user.getId());
		userPlus.setName(user.getName());
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		String token = JWT.create().withHeader(header).withAudience(JSON.toJSONString(user))
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_TIME)).sign(Algorithm.HMAC256(TOKEN_SECRE));

		return token;
	}
	/**
	 * 验证token
	 * @author 周希来
	 * @since 2019年5月5日
	 * @param token
	 * @return
	 */
	public static Boolean checkToken(String token) {
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
	 * 验证token
	 * @author 周希来
	 * @since 2019年5月5日
	 * @param token
	 * @return
	 */
	public static User getUserByToken(String token) {
		
		return  JSON.parseObject(JWT.decode(token).getAudience().get(0), User.class);

	}
	
}
