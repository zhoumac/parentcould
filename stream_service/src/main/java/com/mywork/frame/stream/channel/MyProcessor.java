/**
 * @author 周希来
 * @since 2019年5月20日
 */
package com.mywork.frame.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author 周希来
 * @since 2019年5月20日
 */
public interface MyProcessor {
    String MY_INPUT = "myInput";

    @Input(MY_INPUT)
    SubscribableChannel myInput();

    @Output("myOutput")
    MessageChannel anOutput();

    @Output
    MessageChannel anotherOutput();
}
