package com.lzp.rabbitmq.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
@Component
@Slf4j
public class TestListener {

    @RabbitListener(queues = "directQueue")
    public void getMessage(String message) throws Exception {
        log.info("消费消息:->{}", message);
    }

}
