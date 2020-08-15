package csc.lzp.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
@Component
public class MailBean {

    @Autowired
    private ApplicationContext applicationContext;

    public void sendMail() {
        //todo 为什么这里要传applicationContext?
        //todo 发布邮件事件
        applicationContext.publishEvent(new SpringMailEvent(applicationContext));
    }
}
