package com.iss.test.component;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件，继承ApplicationEvent即可。
 * @Package com.iss.test.component
 * @Description TODO
 * @Author pfwanga  2019/11/21 9:50
 * @Version v1.0
 */
public class SendEmailEvent extends ApplicationEvent {

    private Email email;

    public SendEmailEvent(Email source) {
        super(source);
        this.email = source;
    }

    public void sendEmail(){
        System.out.println("SendEmailEvent.sendEmail process... 开始发送邮件");
        System.out.println("address:" + email.getAddress());
        String currentThread = Thread.currentThread().getName();
        System.out.println("-------------SendEmailEvent.sendEmail: currentThread = " + currentThread);
        System.out.println("content:" + email.getContent());
        System.out.println("SendEmailEvent.sendEmail process... 邮件发送完成");
    }
}

