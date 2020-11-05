package com.lzp.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author: luozhipeng
 * @description: 生产者
 * @data: 2020-11-05
 **/
public class MyKafkaProducer {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        //kafka服务器地址,如果是集群的情况下:指定一个地址也是没有问题的,kafka自动寻找其它kafka服务器
        properties.setProperty("bootstrap.servers", "192.168.208.100:9092");
        //key序列化器
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        //value序列化器
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //主题、?partition?、分区、消息内容
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test-topic", 1, "test-key", "hello");
        Future<RecordMetadata> send = producer.send(record);
        RecordMetadata recordMetadata = send.get();
        System.out.println("记录元数据: " + recordMetadata);
    }

}
