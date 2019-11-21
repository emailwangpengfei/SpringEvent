package com.iss.test.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

/**
 * 事件的发布者
 * @Package com.iss.test.component
 * @Description TODO
 * @Author pfwanga  2019/11/21 9:59
 * @Version v1.0
 */
@Component
public class EventPublisher implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("SendEmailPublisher.setApplicationEventPublisher process...");
        EventPublisher.applicationEventPublisher = applicationEventPublisher;
    }

    public static void publishEvent(ApplicationEvent applicationEvent){
        System.out.println("SendEmailPublisher.publishEvent process  ...");
        ContextLoader.getCurrentWebApplicationContext().publishEvent(applicationEvent);
        //applicationEventPublisher.publishEvent(applicationEvent); // 事件会执行两次
        //因为事件会被 spring 和 springMVC的容器发布
    }
}
