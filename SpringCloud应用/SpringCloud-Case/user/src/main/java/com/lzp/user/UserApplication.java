package com.lzp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ribbonconfig.OrderRuleConfig;
import ribbonconfig.PowerRuleConfig;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/25
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = "com.lzp.user.service")
@RibbonClients({
        @RibbonClient(name = "SERVER-ORDER",configuration = OrderRuleConfig.class),
        @RibbonClient(name = "SERVER-POWER",configuration = PowerRuleConfig.class)
})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
