package com.lzp.eureka3000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/25
 **/
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3000 {

    public static void main(String[] args) {
        SpringApplication.run(AppEureka3000.class, args);
    }

}
