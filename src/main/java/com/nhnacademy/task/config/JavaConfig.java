package com.nhnacademy.task.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.task.DoorayMessageSender;
import com.nhnacademy.task.MessageSendService;
import com.nhnacademy.task.MessageSender;
import com.nhnacademy.task.aspect.LoggingAspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.task")
@PropertySource("classpath:doorayurl.properties")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Value("${url}")
    private String url;

    @Bean
    public DoorayHookSender doorayHookSender() {
        return new DoorayHookSender(new RestTemplate(),url);
    }



}
