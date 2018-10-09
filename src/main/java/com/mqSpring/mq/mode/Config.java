package com.mqSpring.mq.mode;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    //For hello
    @Bean
    Queue queue() {
        return new Queue(Constants.QUEUE_NAME);
    }

    //For topic
    @Bean
    Queue queueOne() {
        System.out.println("queueOne queueOne queueOne queueOne queueOne queueOne");
        return new Queue(Constants.QUEUE_NAME_ONE);
    }

    @Bean
    Queue queueTwo() {
        return new Queue(Constants.QUEUE_NAME_TWO);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(exchange()).with(Constants.ROUTING_KEY_ONE);

    }
    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(exchange()).with(Constants.ROUTING_KEY_TWO);

    }

    //For fanout
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constants.FANOUT_EXCHANGE_NAME);
    }

    @Bean
    Queue queueFanoutOne() {
        return new Queue(Constants.FANOUT_QUEUE_NAME_ONE);
    }

    @Bean
    Queue queueFanoutTwo() {
        return new Queue(Constants.FANOUT_QUEUE_NAME_TWO);
    }

    @Bean
    Binding bindingFanoutOne() {
        return BindingBuilder.bind(queueFanoutOne()).to(fanoutExchange());

    }
    @Bean
    Binding bindingFanoutTwo() {
        return BindingBuilder.bind(queueFanoutTwo()).to(fanoutExchange());

    }
}
