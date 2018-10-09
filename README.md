# SpringbootIntegratedRabbitmq

1) topic 和 fanout模式的差别是fanout,不明确生命key:
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
