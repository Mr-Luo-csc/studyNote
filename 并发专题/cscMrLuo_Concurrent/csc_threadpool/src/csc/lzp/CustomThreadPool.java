package csc.lzp;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Discription: 自定义线程池
 * 了解一下几种拒绝策略
 * @Author: luozhipeng
 **/
public class CustomThreadPool extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            System.out.println("线程异常");
        }
    }

    public static void main(String[] args) {
        //定义阻塞队列、以及大小
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 6, 60, TimeUnit.MICROSECONDS, queue);
        for (int i = 0; i < 20; i++) {
            pool.execute(new CustomThreadPool());
        }
        pool.shutdown();
    }
}
