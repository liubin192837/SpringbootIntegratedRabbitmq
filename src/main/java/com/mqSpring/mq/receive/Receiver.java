package com.mqSpring.mq.receive;

import com.mqSpring.mq.mode.Constants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Receiver {
    @RabbitListener(queues = Constants.QUEUE_NAME)
    @RabbitHandler
    public void receive(String text, Channel channel, Message message) {
        System.out.println("Get :"+ text);
        try {
            System.out.println("two basicAck");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
