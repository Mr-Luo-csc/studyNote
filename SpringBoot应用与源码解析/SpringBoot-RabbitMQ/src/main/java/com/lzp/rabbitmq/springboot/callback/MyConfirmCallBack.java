package com.lzp.rabbitmq.springboot.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-26
 **/
@Slf4j
public class MyConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.warn("correlationData:{}", correlationData);
        log.warn("ack:{}", b);
        log.warn("cause:{}", s);
    }

}
