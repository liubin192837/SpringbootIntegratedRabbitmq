package com.mqSpring.mq.send;

import com.mqSpring.mq.mode.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderTopic {

    private RabbitTemplate rabbitTemplate;

    public SenderTopic(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        setBack(rabbitTemplate);
    }
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

    private void setBack(RabbitTemplate rabbitTemplate) {
        System.out.println("setBack");
        /*rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback(){
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {

            }
        });*/
        //lambda
        rabbitTemplate.setConfirmCallback((correlationData,b, s ) -> {
            System.out.println("q11111111111111111111111111111ConfirmCallback");
            if(b) {
                System.out.println("ack true ");
            } else {
                System.out.println("ack false "+"Cause:"+s+" correlationData"+correlationData.toString());
            }
        });
        rabbitTemplate.setReturnCallback((v1,v2,v3,v4,v5) -> {
            System.out.println("return:"+v1+" v2:"+v2+" v3:"+v3+" v4:"+v4+" v5:"+v5);
        });
    }
}
