package com.lzp.kafka.commands;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import scala.collection.JavaConversions;

import java.util.List;
import java.util.Properties;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-11-05
 **/
public class KafkaUtil {

    /**
     * 创建topic
     */
    public static void createTopic() {
        ZkUtils zkUtils = ZkUtils.apply("192.168.208.100:2181", 30000, 30000, JaasUtils.isZkSaslEnabled());
        System.out.println(JaasUtils.isZkSaslEnabled());
        AdminUtils.createTopic(zkUtils, "t1", 1, 1, new Properties(), AdminUtils.createTopic$default$6());
        zkUtils.close();
    }

    /**
     * 删除topic
     */
    public static void deleteTopic() {
        ZkUtils zkUtils = ZkUtils.apply("192.168.208.100:2181", 30000, 30000, JaasUtils.isZkSaslEnabled());
        AdminUtils.deleteTopic(zkUtils, "t1");
        zkUtils.close();
    }

    /**
     * 列出所有topic
     */
    public static void listTopic() {
        ZkUtils zkUtils = ZkUtils.apply("192.168.208.100:2181", 30000, 30000, JaasUtils.isZkSaslEnabled());
        List<String> list = JavaConversions.seqAsJavaList(zkUtils.getAllTopics());
        for (String s : list) {
            System.out.println("topic: " + s);
        }
        zkUtils.close();
    }
}
