package com.lzp.zuul9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/9/3
 **/
@SpringBootApplication
@EnableZuulProxy
public class Zuul9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul9001Application.class, args);
    }
}
