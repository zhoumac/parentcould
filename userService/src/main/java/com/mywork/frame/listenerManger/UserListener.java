/**
 * @author 周希来
 * @since 2019年4月25日
 */
package com.mywork.frame.listenerManger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.event.TransactionalEventListener;

import com.mywork.frame.eventManger.UserEvent;
import com.mywork.user.sevice.business.UserService;

/**
 * @author 周希来
 * @since 2019年4月25日
 */
@Component
public class UserListener implements ApplicationListener<UserEvent> {
	@Autowired
	private UserService userService;
	/**
	 * @author 周希来
	 * @since 2019年4月25日
	 * @param event
	 */
	//@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) 
	//@TransactionalEventListener//事务提交后执行
	//@Async //开启异步执行
	@Override
	public void onApplicationEvent(UserEvent event) {
		 userService.updateMess(event.getSource());
		
		System.err.println("监听user事件的监听器");
	}
	


}
