package csc.lzp.redislock;

import csc.lzp.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/20
 **/
public class RedisTest {

    public static void main(String[] args) {
        //TODO #? 这里启动不起来,还未找到原因
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RedisLock redisLockUtil = context.getBean(RedisLock.class);
        redisLockUtil.addLock();
        redisLockUtil.boolLock();
    }

}
