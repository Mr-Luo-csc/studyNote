package csc.lzp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class Fixed extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        //创建一个固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //了解线程池的实现原理
        //了解线程池的声明周期
        //出现多线程的地方可以考虑用到线程池
        //案例: servlet3.0 文件夹上传的时候,底层就是通过线程池实现的 可以去了解一下
        //extend thread 是真正的创建线程
        //implements是重写run方法,把实现的这个类放到线程当中去
        for (int i = 0; i < 10; i++) {
            pool.execute(new Fixed());
        }
        while (pool.isTerminated()) {
            //关闭线程池
            pool.shutdown();
        }
    }
}
