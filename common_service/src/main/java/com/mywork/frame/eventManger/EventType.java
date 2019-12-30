/**
 * @author 周希来
 * @since 2019年4月25日
 */
package com.mywork.frame.eventManger;

/**
 * @author 周希来
 * @since 2019年4月25日
 */
public enum EventType {

	REGISTER_USER(1),
	UPDATE_USER(2);
	private Integer type;


	private EventType(Integer type) {
		this.type = type;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
