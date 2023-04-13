package com.nhnacademy.task;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;

public class DoorayMessageSender implements MessageSender {

    DoorayHookSender doorayHookSender;
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
