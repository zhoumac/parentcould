/**
 * @author 周希来
 * @since 2019年4月30日
 */
package com.mywork.frame.Filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.util.IPAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.mywork.frame.util.JwtUtil;
import com.mywork.model.User;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author 周希来
 * @since 2019年4月30日
 */
@RefreshScope
@Component
public class TokenFilter extends ZuulFilter {
	public static Logger log = LogManager.getLogger();
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	 @Value("${zhou.isOpenToken}")
	private boolean isOpenToken;
	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @return 表示是否需要执行该filter，true表示执行，false表示不执行
	 */
	@Override
	public boolean shouldFilter() {
		
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		String uri = request.getRequestURI().toString();
		String method = request.getMethod();
		log.info("url :{}  method: {} ", uri, method);
		if(uri.equals("/user-service/user/login")) {
			return false;
		}
		User user = new User();
		user.setIp("1111111");
		user.setName("周希来");
		user.setId(1);
		log.info(user.toString());
		// 这里可以对url进行判断，以确定是否进入过滤方法
		// 返回true会进入下面的run方法，返回false会跳过
		//过滤的路由
		return true;
	}

	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @return filter需要执行的具体操作
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String token = request.getHeader("token");
		System.out.println(isOpenToken);
		//JwtUtil.getUserByToken(token);
		if(isOpenToken&&!JwtUtil.checkToken(token)){
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);			
			try {
				ctx.getResponse().getWriter().write("token is time out or error ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		log.info("token 验证通过");
		return null;
	}

	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @return 定义filter的类型，有pre、route、post、error四种
	 */
	@Override
	public String filterType() {

		return "pre";
	}

	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @return 定义filter的顺序，数字越小表示顺序越高，越先执行
	 */
	@Override
	public int filterOrder() {

		return 1;
	}

}
