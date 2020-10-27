package com.lzp.rabbitmq.springboot.config;

import com.lzp.rabbitmq.springboot.callback.MyConfirmCallBack;
import com.lzp.rabbitmq.springboot.callback.MyReturnCallBack;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: luozhipeng
 * @description: 1、JavaConfig的方式配置启动rabbitMQ 2、yml的方式
 * @data: 2020-10-23
 **/
@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.208.100", 5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");
        // 是否开启消息确认机制
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("directQueue", false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with("direct.key");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        //todo 注意:这个ConnectionFactory是使用JavaConfig方式配置连接的时候才需要传入的,如果是yml配置的连接的话是不需要的
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //开启mandatory模式(开启失败回调)
        rabbitTemplate.setMandatory(true);
        //指定失败回调接口的实现类
        rabbitTemplate.setReturnCallback(new MyReturnCallBack());
        //指定发送方确认模式的实现类
        rabbitTemplate.setConfirmCallback(new MyConfirmCallBack());
        return rabbitTemplate;
    }

    //todo 实例一个监听器的Container(容器)
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        //这个containerFactory就是我们自己配置的连接工厂直接注册进来
        containerFactory.setConnectionFactory(connectionFactory);
        //这边设置消息确认方式:自动确认=变为=手动确认
        containerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //设置消息预取的数量,前提要是手动确认的
        containerFactory.setPrefetchCount(1);
        return containerFactory;
    }
}
