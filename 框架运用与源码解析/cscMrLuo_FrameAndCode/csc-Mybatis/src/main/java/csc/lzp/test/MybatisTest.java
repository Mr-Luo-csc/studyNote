package csc.lzp.test;

import csc.lzp.config.AppConfig;
import csc.lzp.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/14
 **/
public class MybatisTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean(User.class);
        System.out.println("user中order的属性是否自动注入了: " + user.getOrder());
    }

}
