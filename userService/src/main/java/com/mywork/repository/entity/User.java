/**
 * @author 周希来
 * @since 2019年4月30日
 */
package com.mywork.repository.entity;

import java.io.Serializable;

/**
 * @author 周希来
 * @since 2019年4月30日
 */
public class User implements Serializable {
	/**
	 * @author 周希来
	 * @since 2019年4月30日
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String pass;
	private String ip;
	private String userAgent;
	
	
	
	/**
	 * @author 周希来
	 * @since 2019年5月5日
	 * @return
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", ip=" + ip + ", userAgent=" + userAgent + "]";
	}
	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}
	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
