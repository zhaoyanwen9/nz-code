package com.nz.test.consumer;

import com.example.rabbitmq.consumer.constants.QueueInfoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 */
@Component
@RabbitListener(queues = QueueInfoConstant.FANOUT_QUEUE_1)
public class FanoutReceiverA {

    private static final Logger logger = LoggerFactory.getLogger(FanoutReceiverA.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info(QueueInfoConstant.FANOUT_QUEUE_1 + " -> " + testMessage.toString());
    }
}
