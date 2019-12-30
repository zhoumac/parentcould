/**
 * @author 周希来
 * @since 2019年4月30日
 */
package com.mywork.frame.hystrix;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @author 周希来
 * @since 2019年4月30日
 * 服务熔断
 */
@Component
public class HystrixFallbackProvider implements FallbackProvider {
	public static Logger log =  LogManager.getLogger();
	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @return 配置熔断的服务
	 */
	@Override
	public String getRoute() {
		
		//return "user-service";
		return "*";
	}

	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 * @param route
	 * @param cause
	 * @return
	 */
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		log.info(route);
		log.info(cause);
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
			    HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
            	return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				
				return new ByteArrayInputStream("Sorry, the service is unavailable now.".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
			
				return "ok";
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				
				return 200;
			}
			
			@Override
			public void close() {
				
				log.info("熔断后执行了close");
				
			}
		};
	}

}
