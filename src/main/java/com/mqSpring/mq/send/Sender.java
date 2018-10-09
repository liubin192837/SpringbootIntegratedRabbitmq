package com.mqSpring.mq.send;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        System.out.println("send hello");
        String text = "hello";
        rabbitTemplate.convertAndSend(Constants.QUEUE_NAME ,text);
    }
}
