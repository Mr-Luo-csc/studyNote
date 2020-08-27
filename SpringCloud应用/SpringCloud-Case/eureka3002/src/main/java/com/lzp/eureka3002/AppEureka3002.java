package com.lzp.eureka3002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/26
 **/
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3002 {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka3002.class, args);
    }
}
