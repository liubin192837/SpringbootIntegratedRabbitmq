package com.mqSpring.mq.receive;

import com.mqSpring.mq.mode.Constants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReceiverFanout {
    @RabbitListener(queues = Constants.FANOUT_QUEUE_NAME_ONE)
    @RabbitHandler
    public void receiveOne(String text, Channel channel, Message message) {
        System.out.println("FANOUT_QUEUE_NAME_ONE :"+ text);
        try {
            System.out.println("two basicAck");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_NAME_TWO)
    @RabbitHandler
    public void receiveTwo(String text, Channel channel, Message message) {
        System.out.println("FANOUT_QUEUE_NAME_TWO :"+ text);
        try {
            System.out.println("two basicAck");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
