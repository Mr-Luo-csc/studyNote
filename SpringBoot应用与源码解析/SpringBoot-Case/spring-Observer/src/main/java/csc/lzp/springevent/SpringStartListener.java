package csc.lzp.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
@Component
public class SpringStartListener implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("spring application started");
    }
}
