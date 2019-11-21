package com.iss.test.component;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * 实现接口 的监听器
 * @Package com.iss.test.component
 * @Description TODO
 * @Author pfwanga  2019/11/21 9:53
 * @Version v1.0
 */
//@Component
public class SendEmailListener implements ApplicationListener<SendEmailEvent> {

    @Async
    @Override
    public void onApplicationEvent(SendEmailEvent sendEmailEvent) {
        System.out.println("SendEmailListener.onApplicationEvent process......begin");
        String currentThread = Thread.currentThread().getName();
        System.out.println("-------------SendEmailListener currentThread = " + currentThread);
        sendEmailEvent.sendEmail();
        System.out.println("SendEmailListener.onApplicationEvent process......end");
    }
}
