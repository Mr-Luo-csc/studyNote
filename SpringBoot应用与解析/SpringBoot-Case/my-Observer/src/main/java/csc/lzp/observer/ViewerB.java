package csc.lzp.observer;

import csc.lzp.event.MovieEvent;
import csc.lzp.monitor.MonitorListener;

/**
 * @Description: 观影人B
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class ViewerB implements MonitorListener {

    @Override
    public void update(MovieEvent movieEvent) {
        if (movieEvent.getType() == 1) {
            System.out.println("ViewerB: " + "smile...");
        }
    }

}
