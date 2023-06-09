package com.nhnacademy.task;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.web.client.RestTemplate;

public class DoorayMessageSender implements MessageSender {

    DoorayHookSender doorayHookSender;
    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
        System.out.println("dooray message initiated!!");
    }

    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder()
                        .botName(user.getEmail())
                        .text(message)
                        .build());
        return true;
    }
}
