package com.iss.test.component.use.annotation;

import com.iss.test.component.SendEmailEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 注解 的监听器
 * @Package com.iss.test.component.use
 * @Description TODO
 * @Author pfwanga  2019/11/21 14:00
 * @Version v1.0
 */
@Component
public class SendEmailHandler {

    //@Async    //异步执行
    @EventListener  //传入对应的事件类型即可
    public void handleEvent(SendEmailEvent event){
        System.out.println("SendEmailHandler.handleEvent process......begin");
        String currentThread = Thread.currentThread().getName();
        System.out.println("-------------SendEmailHandler.handleEvent: currentThread = " + currentThread);
        event.sendEmail();
        System.out.println("SendEmailHandler.handleEvent process......end");
    }
}
