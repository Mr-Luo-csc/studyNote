package com.lzp.kafka.cousumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-11-05
 **/
public class MyKafkaConsumer {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        //kafka服务器地址,如果是集群的情况下:指定一个地址也是没有问题的,kafka自动寻找其它kafka服务器
        properties.setProperty("bootstrap.servers", "192.168.208.100:9092");
        //key序列化器
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        //value序列化器
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        //设置消费者组
        properties.setProperty("group.id", "火影七班");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        //订阅主题
        consumer.subscribe(Collections.singletonList("test-topic"));
        //消费
        /*while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(500);
            for (ConsumerRecord<String, String> record : poll) {
                //ConsumerRecords这是一个迭代器
                System.out.println("消费消息: " + record);
            }
        }*/

        //偏移量,偏移量提交
        try {
            while (true) {
                ConsumerRecords<String, String> poll = consumer.poll(500);
                for (ConsumerRecord<String, String> context : poll) {
                    System.out.println("消息所在分区:" + context.partition() + "-消息的偏移量:" + context.offset() + "key:" + context.key() + "value:" + context.value());
                }
                //正常情况异步提交
                consumer.commitAsync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //当程序中断时同步提交
                consumer.commitSync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //关闭当前消费者 具体在下面有讲
                consumer.close();
            }
        }

    }

}