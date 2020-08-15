package csc.lzp.lockzookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Discription: zk分布式锁
 * @Author: luozhipeng
 * @Date: 2020/7/20
 **/
public class ZooKeeperSession {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private ZooKeeper zooKeeper;
    private CountDownLatch latch;

    //---------构造方法
    public ZooKeeperSession() {
        try {
            this.zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZooKeeperWatcher());
            try {
                connectedSemaphore.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("zookeeper session established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------建立 zk session 的 watcher
    private class ZooKeeperWatcher implements Watcher {

        public void process(WatchedEvent watchedEvent) {
            System.out.println("Receive watched event: " + watchedEvent.getState());

            if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                connectedSemaphore.countDown();
            }

            if (latch != null) {
                latch.countDown();
            }
        }
    }

    //---------获取分布式锁 redis和zookeeper两者生成锁都是依靠自己的[特性]来生成的(自己的理解)
    public Boolean acquireDistributedLock(Long goodId) {
        String path = "/good-lock-" + goodId;
        try {
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            return true;
        } catch (Exception e) {
            while (true) {
                try {
                    Stat stat = zooKeeper.exists(path, true);
                    if (stat != null) {
                        this.latch = new CountDownLatch(1);
                        this.latch.await(30000, TimeUnit.MILLISECONDS);
                        this.latch = null;
                    }
                    zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                    return true;
                } catch (Exception ex) {
                    continue;
                }
            }
        }
    }

    //---------释放分布式锁
    public void releaseDistributedLock(Long goodId) {
        String path = "/good-lock-" + goodId;
        try {
            zooKeeper.delete(path, -1);
            System.out.println("release the lock for good[id=" + goodId + "]......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------封装单例的静态内部类
    private static class Singleton {
        private static ZooKeeperSession instance;

        static {
            instance = new ZooKeeperSession();
        }

        public static ZooKeeperSession getInstance() {
            return instance;
        }
    }

    //---------获取单例
    public static ZooKeeperSession getInstance() {
        return Singleton.getInstance();
    }

    //---------初始化单例的便捷方法
    public static void init() {
        getInstance();
    }
}
