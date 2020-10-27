package com.lzp.rabbitmq.springboot.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-27
 **/
@Component
@Slf4j
public class SceneListener {

    @RabbitListener(queues = "testQueue", containerFactory = "simpleRabbitListenerContainerFactory")
    public void getMessage(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody(), "UTF-8");
        System.out.println(msg);
        System.out.println(message.getBody());

        boolean isOk = placeAnOrder();
        if (isOk) {
            //消息唯一标示、是否批量确认
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } else {
            //批量
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);//第三个参数:是否把消息返回原队列
            //单条
            //channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }

    /* 模拟下订单操作 */
    private boolean placeAnOrder() {
        return false;
    }

}
