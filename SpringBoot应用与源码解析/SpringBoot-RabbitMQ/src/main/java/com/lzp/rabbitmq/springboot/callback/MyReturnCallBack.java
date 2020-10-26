package com.lzp.rabbitmq.springboot.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-26
 **/
@Slf4j
public class MyReturnCallBack implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.warn("message:{}", message);
        log.warn("replyCode:{}", i);
        log.warn("replyText:{}", s);
        log.warn("exchange:{}", s1);
        log.warn("routingKey:{}", s2);
    }

}
