package com.nhnacademy.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.task")){
            MessageSendService messageSendService = context.getBean("messageSendService",MessageSendService.class);
            messageSendService.doSendMessage();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}