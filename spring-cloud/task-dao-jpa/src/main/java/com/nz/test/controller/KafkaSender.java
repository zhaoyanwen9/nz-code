package com.nz.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * kafka生产者
 *
 * @author ：zhangqiang
 * @create ：2018-09-05 17:03
 **/
@Component
public class KafkaSender {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);

//    @Autowired
//    private KafkaTemplate kafkaTemplate;

    //自定义topic
//    public static final String TOPIC_ONE = "topic.one";

    public String send(Object obj) {
        final String msg ="success";
        logger.info("准备发送消息为：{}", obj);
        //发送消息
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_ONE, obj);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                //发送失败的处理
//                logger.info(TOPIC_ONE + " - 生产者 发送消息失败：" + throwable.getMessage());
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
//                //成功的处理
//                logger.info(TOPIC_ONE + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
//            }
//        });
        return msg;
    }
}