package csc.lzp.jdk.observed;

import java.util.Observable;

/**
 * @Description: 被观察者[电影]
 * @Author: luozhipeng
 * @Date: 2020/8/15
 **/
public class MovieJDK extends Observable {

    //电影出现打斗动作时触发的方法
    public void move() {
        //todo 调用以下两个方法触发观察者
        //todo JDK好像封装了事件? answer: notifyObservers()方法中可以传入一个参数,我们用来传入事件对象
        setChanged();
        notifyObservers();
    }

}
