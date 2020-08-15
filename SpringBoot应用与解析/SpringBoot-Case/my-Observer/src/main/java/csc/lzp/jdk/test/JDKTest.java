package csc.lzp.jdk.test;

import csc.lzp.jdk.observed.MovieJDK;
import csc.lzp.jdk.observer.ViewerAJDK;
import csc.lzp.jdk.observer.ViewerBJDK;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
public class JDKTest {

    public static void main(String[] args) {
        MovieJDK movieJDK = new MovieJDK();
        //todo 看这个Observer的执行顺序,先添加的观察者,后执行
        movieJDK.addObserver(new ViewerAJDK());
        movieJDK.addObserver(new ViewerBJDK());
        movieJDK.move();
    }

}
