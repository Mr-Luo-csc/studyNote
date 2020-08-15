package csc.lzp.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
@Component
public class SpringMailListener implements ApplicationListener<SpringMailEvent> {

    @Override
    public void onApplicationEvent(SpringMailEvent event) {
        //todo 这里可以实现自己的业务逻辑
        if (null != event.getContent()) {

        }
        System.out.println("事件监听器...邮箱事件触发...邮件发送成功");
    }

}
