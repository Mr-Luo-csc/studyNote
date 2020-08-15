package csc.lzp.config;

import com.snowalker.lock.redisson.config.EnableRedissonLock;
import csc.lzp.anno.EnableDbConfigAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Discription: 使用配置类的方式初始化Spring上下文环境
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Configuration
@ComponentScan(basePackages = {"csc.lzp"})
@EnableDbConfigAnnotation(username = "mr-luo", password = "123456")
//@EnableRedissonLock
public class AppConfig {

}
