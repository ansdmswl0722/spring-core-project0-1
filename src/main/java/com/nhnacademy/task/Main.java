package com.nhnacademy.task;

import com.nhnacademy.task.DoorayMessageSender;
import com.nhnacademy.task.MessageSendService;
import com.nhnacademy.task.MessageSender;
import com.nhnacademy.task.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            MessageSendService messageSendService = context.getBean("messageSendService",MessageSendService.class);
            messageSendService.doSendMessage();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}