# SpringbootIntegratedRabbitmq
//模式
1). topic 和 fanout模式的差别是fanout,不明确生命key:

https://github.com/liubin192837/SpringbootIntegratedRabbitmq/blob/master/src/main/java/com/mqSpring/mq/mode/Config.java

    //fanout 模式
    @Bean
    Binding bindingFanoutOne() {
        return BindingBuilder.bind(queueFanoutOne()).to(fanoutExchange());

    }
    
    //topic 模式,明确声明key
    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(exchange()).with(Constants.ROUTING_KEY_ONE);

    }
2).  topic 和 Routing 声明上相似, 不同的是topic如明是主题性的,带有模糊匹配,Routing则是固定无法模糊匹配的.

3). "Hello World!" 和 Work Queues 模式则是无需声明 exchange,直接借助queue进行交互


当然使用mq的客户端代码需要生命type来选择哪种模式,和spring结合, 非"Hello World!" 和 Work Queues 模式则要选择对应的exchange(TopicExchange/FanoutExchange)实现类.

//ack
1) setConfirmCallback收到回执,只是说明找到对应的queue,并发送了,并不是表示这个消息真的处理了.自动模式就可体现出这点

