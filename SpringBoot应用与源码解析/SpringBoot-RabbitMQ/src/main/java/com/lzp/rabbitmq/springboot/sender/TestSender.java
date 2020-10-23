package com.lzp.rabbitmq.springboot.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
@Component
public class TestSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("directExchange", "direct.key", "很高心认识你");
    }

}
