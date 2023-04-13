package com.nhnacademy.task.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.task.DoorayMessageSender;
import com.nhnacademy.task.MessageSendService;
import com.nhnacademy.task.MessageSender;
import com.nhnacademy.task.aspect.LoggingAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:doorayurl.properties")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Value("${url}")
    private String url;
    @Bean
    public MessageSender doorayMessageSender(DoorayHookSender doorayHookSender) {
        return new DoorayMessageSender(doorayHookSender);
    }
    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(),url);
    }

    @Bean
    public MessageSendService messageSendService(MessageSender doorayMessageSender) {
        return new MessageSendService(doorayMessageSender);
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
