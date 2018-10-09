package com.mqSpring.mq.send;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderTopic {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOne() {
        System.out.println("send one");
        String text = "hello ROUTING_KEY_ONE";
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME,Constants.ROUTING_KEY_ONE, text);
    }

    public void sendTwo() {
        System.out.println("send two");
        String text = "hello ROUTING_KEY_TWO";;
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME,Constants.ROUTING_KEY_TWO, text);
    }

    public void sendThree() {
        System.out.println("send three");
        String text = "hello ROUTING_KEY_Three";;
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME,Constants.ROUTING_KEY_THREE, text);
    }
}
