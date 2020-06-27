package csc.lzp.config;

import csc.lzp.anno.CSCScan;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/16
 **/
@Configurable
@ComponentScan(basePackages = {"csc.lzp.service", "csc.lzp.dao"})
//@MapperScan("csc.lzp.dao")
@CSCScan
public class AppConfig {

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
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

//    @Bean
//    @Autowired
//    public SqlSessionFactoryBean sqlSessionFactoryBean2(DataSource dataSource2) {
//        SqlSessionFactoryBean sqlSessionFactoryBean2 = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean2.setDataSource(dataSource2);
//        return sqlSessionFactoryBean2;
//    }
//
//    @Bean
//    public DataSource dataSource2() {
//        DriverManagerDataSource driverManagerDataSource2 = new DriverManagerDataSource();
//        driverManagerDataSource2.setUsername("postgres");
//        driverManagerDataSource2.setPassword("root");
//        driverManagerDataSource2.setUrl("jdbc:postgresql://localhost:5432/test");
//        driverManagerDataSource2.setDriverClassName("org.postgresql.Driver");
//        return driverManagerDataSource2;
//    }

}
