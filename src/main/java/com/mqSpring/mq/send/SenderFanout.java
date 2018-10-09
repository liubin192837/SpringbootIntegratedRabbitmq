package com.mqSpring.mq.send;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderFanout {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanout() {
        System.out.println("send fanout");
        String text = "hello Fanout";
        rabbitTemplate.convertAndSend(Constants.FANOUT_EXCHANGE_NAME, "", text);
    }
}
