package com.nz.test.controller;

//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

//import java.util.Optional;

/**消费者
 * @author ：zhangqiang
 * @create ：2018-09-05 17:17
 **/
@Component
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

//    @KafkaListener(topics = KafkaSender.TOPIC_ONE,groupId = KafkaSender.TOPIC_ONE)
//    public void topic_one(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
//
//        Optional message=Optional.ofNullable(record.value());
//        if (message.isPresent()){
//            Object msg=message.get();
//            logger.info("被"+KafkaSender.TOPIC_ONE+"消费了： +++++++++++++++ Topic:" + topic+",Record:" + record+",Message:" + msg);
//        }
//    }

}
