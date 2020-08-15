package csc.lzp.handwrite.observed;

import csc.lzp.handwrite.event.MovieEvent;
import csc.lzp.handwrite.monitor.MonitorListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 电影(被监听者)
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class Movie implements Runnable {

    private List<MonitorListener> listeners = new ArrayList<>();

    //======设置监听者
    public void addListener(MonitorListener monitorListener) {
        this.listeners.add(monitorListener);
    }

    //======播放电影的动作
    public void play() {
        try {
            //播放5s之后,电影出现打斗动作,开始触发观影者去做别的事情
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MovieEvent movieEvent = new MovieEvent(this);
        movieEvent.setContent("lonely someone 处于一个人的环境下");
        movieEvent.setType(1);
        //主动将事件给观影者,让观影者去做其它事情
        for (MonitorListener listener : listeners) {
            listener.update(movieEvent);
        }
    }

    @Override
    public void run() {
        //使用线程调用播放电影的动作
        play();
    }
}
