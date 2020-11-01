package com.nz.test.config;

import com.nz.test.constants.QueueInfoConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue queueA() {
        return new Queue(QueueInfoConstant.FANOUT_QUEUE_1);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QueueInfoConstant.FANOUT_QUEUE_2);
    }

    @Bean
    public Queue queueC() {
        return new Queue(QueueInfoConstant.FANOUT_QUEUE_3);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(QueueInfoConstant.FANOUT_QUEUE_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }
}

