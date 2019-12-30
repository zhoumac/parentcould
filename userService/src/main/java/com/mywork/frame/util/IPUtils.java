/**
 * @author 周希来
 * @since 2019年5月5日
 */
package com.mywork.frame.util;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 周希来
 * @since 2019年5月5日
 */
public class IPUtils {
	

     /**
      * 获取IP地址
      * 
      * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
      * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
      */
     public static String getIpAddr(HttpServletRequest request) {

                    String ip = request.getHeader("x-forwarded-for");
                    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                   ip = request.getHeader("Proxy-Client-IP");
                    }
                    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                   ip = request.getHeader("WL-Proxy-Client-IP");
                    }
                    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                   ip = request.getRemoteAddr();
                    }
                    return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
     }
     public static String getUserAgent(HttpServletRequest request) {
		 String s1 = request.getHeader("user-agent");
	
		 if(s1.contains("Android")) {
			 s1 ="Android移动客户端";
		 } else if(s1.contains("iPhone")) {
			 s1 ="iPhone移动客户端";
		 }  else if(s1.contains("iPad")) {
			 s1 ="iPad客户端";
		 }  else {
			 //s1 ="其他客户端";
		 }
		 return s1;
     }

}
