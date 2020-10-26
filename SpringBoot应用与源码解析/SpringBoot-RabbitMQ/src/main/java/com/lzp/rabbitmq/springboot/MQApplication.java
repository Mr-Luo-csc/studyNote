package com.lzp.rabbitmq.springboot;

import com.lzp.rabbitmq.springboot.sender.TestSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-10-23
 **/
@SpringBootApplication
@Slf4j
public class MQApplication {

    public static void main(String[] args) {
        //ConfigurableApplicationContext
        SpringApplication application = new SpringApplication(MQApplication.class);
        ConfigurableApplicationContext applicationContext = application.run(args);
        TestSender sender = applicationContext.getBean(TestSender.class);
        sender.send();
        log.info("项目启动正常...");
    }

}
