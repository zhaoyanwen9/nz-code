package com.nz.test.consumer;


import com.nz.test.constants.QueueInfoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * @author nz
 */
@Component
@RabbitListener(queues = QueueInfoConstant.FANOUT_QUEUE_3)
public class FanoutReceiverC {

    private static final Logger logger = LoggerFactory.getLogger(FanoutReceiverC.class);

    @RabbitHandler
    public void process(Map testMessage) {
        logger.info(QueueInfoConstant.FANOUT_QUEUE_3 +" -> " +testMessage.toString());
    }

}

