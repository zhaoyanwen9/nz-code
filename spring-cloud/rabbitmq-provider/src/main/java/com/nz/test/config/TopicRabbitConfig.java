package com.nz.test.config;

import com.example.rabbitmq.provider.constants.QueueInfoConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/

@Configuration
public class TopicRabbitConfig {


    @Bean
    public Queue chaosTaskTopicQueue() {
        return new Queue(QueueInfoConstant.TOPIC_QUEUE_1);
    }

    @Bean
    public Queue allTaskTopicQueue() {
        return new Queue(QueueInfoConstant.TOPIC_QUEUE_2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(QueueInfoConstant.TOPIC_QUEUE_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(chaosTaskTopicQueue()).to(exchange()).with(QueueInfoConstant.TOPIC_QUEUE_1);
    }

    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(allTaskTopicQueue()).to(exchange()).with(QueueInfoConstant.TOPIC_QUEUE_ALL);
    }

}
