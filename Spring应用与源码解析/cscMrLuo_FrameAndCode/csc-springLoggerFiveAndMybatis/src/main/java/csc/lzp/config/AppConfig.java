package csc.lzp.config;

import org.apache.ibatis.logging.Log;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Discription: dataSource()可以代表一个bean实例
 * @Author: luozhipeng
 * @Date: 2020/7/7
 **/
@Configuration
public class AppConfig {

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //配置日志实现 #TODO
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //todo 这里强转有问题
        configuration.setLogImpl((Class<? extends Log>) Logger.class);
        sqlSessionFactoryBean.setConfiguration(configuration);

        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("admin123");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return driverManagerDataSource;
    }

}
