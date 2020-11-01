package com.nz.test.consumer;


import com.example.rabbitmq.consumer.constants.QueueInfoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Component
@RabbitListener(queues = QueueInfoConstant.TOPIC_QUEUE_1)
public class TopicManReceiver {

    private static final Logger logger = LoggerFactory.getLogger(TopicManReceiver.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info(QueueInfoConstant.TOPIC_QUEUE_1 +" -> " + testMessage.toString());
    }
}
