package csc.lzp.config;

import csc.lzp.dao.Dao;
import csc.lzp.dao.IndexDao1;
import csc.lzp.dao.IndexDao2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Discription: FULL and LITE
 * @Author: luozhipeng
 * @Date: 2020/6/30
 **/
@Configuration
@ComponentScan(basePackages = "csc.lzp")
public class AppConfig {

    @Bean
    public Dao index1() {
        return new IndexDao1();
    }

    @Bean
    public Dao index2() {
        return new IndexDao2();
    }

}
