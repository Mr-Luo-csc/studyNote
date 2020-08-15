package csc.lzp.jdk.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: JDK观察者-A
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
public class ViewerAJDK implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ViewerAJDK: 监听到move电影动作....");
    }

}
