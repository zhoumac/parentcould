/**
 * @author 周希来
 * @since 2019年5月21日
 */
package com.mywork.frame.stream.listener;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import com.mywork.model.User;
import com.mywork.stream.channel.DefaultChannel;

/**
 * @author 周希来
 * @since 2019年5月21日
 */
@Component
@EnableBinding(DefaultChannel.class)
public class MessageListener {
	@StreamListener(DefaultChannel.MY_INPUT)//此注解带消息转换
	@SendTo(DefaultChannel.MY_OUTPUT)//消息响应
	public Object input(Message<User>  message) {
		System.err.println("接收到消息："+message.getPayload().toString());
		return "success";
	}
}
