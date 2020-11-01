package com.nz.test.consumer;

import com.example.rabbitmq.consumer.constants.QueueInfoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 一、什么是direct（直接交换模式）
 * 生产者和消费者，具有相同的交换机名称（Exchange）、交换机类型和相同的密匙（routingKey），那么消费者即可成功获取到消息。
 * 监听的队列名称 TestDirectQueue
 * @author nz
 */
@Component
@RabbitListener(queues = QueueInfoConstant.DIRECT_QUEUE)
public class DirectReceiver {

    private static final Logger logger = LoggerFactory.getLogger(DirectReceiver.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info(QueueInfoConstant.DIRECT_QUEUE +" -> " + testMessage.toString());
    }

}
