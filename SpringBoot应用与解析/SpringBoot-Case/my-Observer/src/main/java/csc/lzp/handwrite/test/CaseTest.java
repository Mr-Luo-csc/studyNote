package csc.lzp.handwrite.test;

import csc.lzp.handwrite.observed.Movie;
import csc.lzp.handwrite.observer.ViewerA;
import csc.lzp.handwrite.observer.ViewerB;

/**
 * @Description: 测试手写的观察者模式案例
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class CaseTest {

    public static void main(String[] args) {

        Movie movie = new Movie();
        movie.addListener(new ViewerA());
        movie.addListener(new ViewerB());

        Thread thread = new Thread(movie);
        thread.start();
    }

}
