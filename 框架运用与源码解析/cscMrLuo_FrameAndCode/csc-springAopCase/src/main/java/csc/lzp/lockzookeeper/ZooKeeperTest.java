package csc.lzp.lockzookeeper;

/**
 * @Discription: zk获取分布式锁测试类
 * @Author: luozhipeng
 * @Date: 2020/7/21
 **/
public class ZooKeeperTest {

    public static void main(String[] args) {
        //TODO 测试使用zk分布式锁
        ZooKeeperSession.init();
        ZooKeeperSession zooKeeperSession = ZooKeeperSession.getInstance();
        zooKeeperSession.releaseDistributedLock(0731L);

    }

}
