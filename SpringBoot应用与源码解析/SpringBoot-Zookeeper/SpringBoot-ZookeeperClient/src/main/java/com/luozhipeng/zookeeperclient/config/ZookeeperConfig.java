package com.luozhipeng.zookeeperclient.config;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-09-25
 **/
@Configuration
public class ZookeeperConfig {

    @Value("${zookeeper.address}")
    private String connectAddress;

    @Value("${zookeeper.timeout}")
    private int timeout;

    public ZooKeeper zooKeeperClient() {
        ZooKeeper zooKeeper = null;

        return null;
    }

}
