package com.lzp.rabbitmq.primitive.consumer;

import com.lzp.rabbitmq.primitive.util.ConnectionUtil;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
@Slf4j
public class Consumer {

    public static void getMessage() throws Exception {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = ConnectionUtil.getConnection();
            channel = connection.createChannel();
            DefaultConsumer deliverCallback = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //super.handleDelivery(consumerTag, envelope, properties, body);
                    System.out.println(new String(body, "UTF-8"));
                    log.info("消费者消费消息: ->{}", new String(body, "UTF-8"));
                }
            };
            channel.basicConsume(ConnectionUtil.QUEUE_NAME, deliverCallback);
        } finally {
            channel.close();
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        getMessage();
    }

}
