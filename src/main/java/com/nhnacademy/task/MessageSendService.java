package com.nhnacademy.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageSendService")
public class MessageSendService {

    private final MessageSender messageSender;

    @Autowired
    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean doSendMessage() {
        User user = new User("test@dooray.com","01012341234");
        return messageSender.sendMessage(user, "hihi" );
    }
}
