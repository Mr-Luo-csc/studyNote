package com.lzp.config1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/9/7
 **/
@SpringBootApplication
@EnableConfigServer
public class Config1Application {

    public static void main(String[] args) {
        SpringApplication.run(Config1Application.class, args);
    }
}
