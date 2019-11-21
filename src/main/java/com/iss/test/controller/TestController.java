package com.iss.test.controller;

import com.iss.test.component.Email;
import com.iss.test.component.SendEmailEvent;
import com.iss.test.component.EventPublisher;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package com.iss.test.controller
 * @Description TODO
 * @Author pfwanga  2019/11/21 9:39
 * @Version v1.0
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test1(){
        return "test";
    }

    @RequestMapping(value = "/testEvent",method = RequestMethod.GET)
    @ResponseBody
    public String testEvent(){
        Email email = new Email();
        email.setAddress("sichuan chengdu");
        email.setContent("congrantuations !!!");
        ApplicationEvent sendEmailEvent = new SendEmailEvent(email);
        EventPublisher.publishEvent(sendEmailEvent);
        String currentThread = Thread.currentThread().getName();
        System.out.println("-------------TestController currentThread = " + currentThread);
        return "success";
    }
}
