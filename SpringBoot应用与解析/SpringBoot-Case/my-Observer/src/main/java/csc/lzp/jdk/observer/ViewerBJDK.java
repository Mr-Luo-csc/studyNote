package csc.lzp.jdk.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: JDK观察者-B
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
public class ViewerBJDK implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ViewerBJDK: 监听到move电影动作....");
    }

}
