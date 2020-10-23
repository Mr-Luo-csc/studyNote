package com.lzp.rabbitmq.primitive.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
public class ConnectionUtil {

    public static final String QUEUE_NAME = "testQueue";

    public static final String EXCHANGE_NAME = "testExchange";

    public static Connection getConnection() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.208.100");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory.newConnection();
    }

}
