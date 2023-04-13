package com.nhnacademy.task;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class DoorayMessageSender implements MessageSender {

    DoorayHookSender doorayHookSender;
    @Autowired
    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @ElapsedTimeLog
    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                        .botName(user.getEmail())
                        .text(message)
                        .build());
        return true;
    }
}
