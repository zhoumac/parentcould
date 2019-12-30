/**
 * @author 周希来
 * @since 2019年5月20日
 */
package com.mywork.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author 周希来
 * @since 2019年5月20日
 */
public interface DefaultChannel {
    String MY_INPUT = "myInput";
    String MY_INPUTBACK = "myInputBack";
    String MY_OUTPUT = "myOutput";
    String MY_OUTPUTBACK = "myOutputBack";
    
    @Input(MY_INPUT)
    SubscribableChannel myInput();
    @Input(MY_INPUTBACK)
    SubscribableChannel myInputBack();
    
    @Output(MY_OUTPUT)
    MessageChannel myOutput();
    @Output(MY_OUTPUTBACK)
    MessageChannel myOutputBack();


}
