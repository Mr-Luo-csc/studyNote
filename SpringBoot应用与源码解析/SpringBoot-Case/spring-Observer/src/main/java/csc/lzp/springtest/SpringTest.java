package csc.lzp.springtest;

import csc.lzp.config.AppConfig;
import csc.lzp.springevent.MailBean;
import csc.lzp.springevent.SpringMailListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context.addApplicationListener(new SpringMailListener());todo 这里与 SpringMailListener是否加@Component注解
        //context.start();
        MailBean mailBean = context.getBean(MailBean.class);
        mailBean.sendMail();
    }

}
