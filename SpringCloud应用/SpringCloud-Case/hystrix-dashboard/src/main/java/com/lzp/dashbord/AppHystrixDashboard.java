package com.lzp.dashbord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/9/4
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class AppHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(AppHystrixDashboard.class, args);
    }
}
