package com.mqSpring.mq.mode;

public class Constants {
    //exchange name
    public static final String EXCHANGE_NAME = "exchange_name";
    public static final String FANOUT_EXCHANGE_NAME = "fanout_exchange_name";
    //queue name for topic
    public static final String QUEUE_NAME = "queue_name";
    public static final String QUEUE_NAME_ONE = "queue_name_one";
    public static final String QUEUE_NAME_TWO = "queue_name_two";
    //queue name for fanout
    public static final String FANOUT_QUEUE_NAME_ONE = "fanout_queue_name_one";
    public static final String FANOUT_QUEUE_NAME_TWO = "fanout_queue_name_two";
    //routing key
    public static final String ROUTING_KEY_ONE = "*.one.#";
    public static final String ROUTING_KEY_TWO = "*.two.#";
    public static final String ROUTING_KEY_THREE = "routingKey.three.*";
}
