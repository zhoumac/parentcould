/**
 * @author 周希来
 * @since 2019年4月25日
 */
package com.mywork.frame.eventManger;

import org.springframework.context.ApplicationEvent;

/**
 * @author 周希来
 * @since 2019年4月25日
 */

public class UserEvent extends ApplicationEvent {

	/**
	 * @author 周希来
	 * @since 2019年4月25日
	 * @param source
	 */
	public UserEvent(Object source) {
		super(source);

	}

	/**
	 * @author 周希来
	 * @since 2019年4月25日
	 */
	private static final long serialVersionUID = 1L;
	
}
