package com.mqSpring.mq.receive;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = Constants.QUEUE_NAME)
    @RabbitHandler
    public void receive(String text) {
        System.out.println("Get :"+ text);
    }

}
