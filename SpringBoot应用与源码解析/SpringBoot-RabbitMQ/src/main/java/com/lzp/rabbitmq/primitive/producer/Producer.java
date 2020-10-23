package com.lzp.rabbitmq.primitive.producer;

import com.lzp.rabbitmq.primitive.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
@Slf4j
public class Producer {

    public static void sendByExchange(String message) throws Exception {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = ConnectionUtil.getConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(ConnectionUtil.EXCHANGE_NAME, "fanout");
            channel.queueDeclare(ConnectionUtil.QUEUE_NAME, true, false, false, null);
            channel.queueBind(ConnectionUtil.QUEUE_NAME, ConnectionUtil.EXCHANGE_NAME, "");
            channel.basicPublish(ConnectionUtil.EXCHANGE_NAME, "", null, message.getBytes());
            log.info("生产者发送消息内容: " + message);
        } finally {
            channel.close();
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        sendByExchange("IT技术行业到底需要怎样的人?");
    }

}
