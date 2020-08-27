package com.lzp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/25
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = "com.lzp.user.service")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
