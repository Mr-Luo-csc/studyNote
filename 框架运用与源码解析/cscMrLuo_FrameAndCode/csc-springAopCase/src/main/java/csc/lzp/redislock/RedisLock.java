package csc.lzp.redislock;

import com.snowalker.lock.redisson.RedissonLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Discription: 测试使用Redis的分布式锁的使用
 * @Author: luozhipeng
 * @Date: 2020/7/20
 **/
//@Component
public class RedisLock {

    /*******************/
    /**     使用步骤    */
    /** 1、添加锁       */
    /** 2、获取锁       */
    /** 3、释放锁       */
    /*******************/

    @Autowired
    private RedissonLock redissonLock;

    //---------添加锁
    public void addLock() {
        boolean lock = redissonLock.lock("key_L", 1);
        if (lock) {
            System.out.println("添加分布式锁成功");
        }
    }

    //---------锁是否存在、存在的话就释放
    public void boolLock() {
        if (!(redissonLock.lock("key_L", 1))) {
            System.err.println("key_L锁已经释放或不存在...");
        }
        //---------释放锁
        redissonLock.release("key_L");
    }

}
