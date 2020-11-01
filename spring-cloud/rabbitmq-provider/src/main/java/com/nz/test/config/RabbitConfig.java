package com.nz.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class RabbitConfig {

    private static final Logger logger = LoggerFactory.getLogger(RabbitConfig.class);

    /**
     * //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                logger.info("ConfirmCallback: " + "相关数据：" + correlationData);
                logger.info("ConfirmCallback: " + "确认情况：" + ack);
                logger.info("ConfirmCallback: " + "原因：" + cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                logger.info("ReturnCallback: " + "消息：" + message);
                logger.info("ReturnCallback: " + "回应码：" + replyCode);
                logger.info("ReturnCallback: " + "回应信息：" + replyText);
                logger.info("ReturnCallback: " + "交换机：" + exchange);
                logger.info("ReturnCallback: " + "路由键：" + routingKey);
            }
        });
        return rabbitTemplate;
    }

}
