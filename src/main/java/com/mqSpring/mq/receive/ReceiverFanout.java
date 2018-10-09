package com.mqSpring.mq.receive;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverFanout {
    @RabbitListener(queues = Constants.FANOUT_QUEUE_NAME_ONE)
    @RabbitHandler
    public void receiveOne(String text) {
        System.out.println("FANOUT_QUEUE_NAME_ONE :"+ text);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_NAME_TWO)
    @RabbitHandler
    public void receiveTwo(String text) {
        System.out.println("FANOUT_QUEUE_NAME_TWO :"+ text);
    }
}
