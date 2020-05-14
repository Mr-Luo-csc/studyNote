package csc.lzp;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class Scheduled extends Thread {
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
        ExecutorService pool = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 10; i++) {
            pool.execute(new Scheduled());
        }
        pool.shutdown();
    }
}
