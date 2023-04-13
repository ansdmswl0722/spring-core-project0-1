package com.nhnacademy.task;

public class MessageSendService {

    private final MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage() {
        User user = new User("test@dooray.com","01012341234");
        return messageSender.sendMessage(user, "hihi" );
    }
}
