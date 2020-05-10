package csc.lzp;

import java.util.concurrent.TimeUnit;

/**
 * @Discription: 一个读一个写
 * @Author: luozhipeng
 **/
public class MyVolatile {
    final static int MaxValue = 50;
    static volatile int index = 0;//volatile霸道性,其它线程不读缓冲中的数据,直接去内存中读数据

    public static void increase() {
        index++;
    }

    public static void main(String[] args) {
        //读线程
        new Thread(() -> {
            int localValue = index;
            while (index < MaxValue) {
                System.out.println("Reader: " + index);
            }
        }, "Reader").start();

        //写线程
        new Thread(() -> {
            while (index < MaxValue) {
                int localValue = index;
                increase();
                localValue = index;
                System.out.println("Updater: " + index);
            }
        }, "Updater").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("线程异常");
        }
    }
}
