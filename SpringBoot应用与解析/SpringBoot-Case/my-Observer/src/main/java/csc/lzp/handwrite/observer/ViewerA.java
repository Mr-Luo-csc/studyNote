package csc.lzp.handwrite.observer;

import csc.lzp.handwrite.event.MovieEvent;
import csc.lzp.handwrite.monitor.MonitorListener;

/**
 * @Description: 观影人A
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class ViewerA implements MonitorListener {

    @Override
    public void update(MovieEvent movieEvent) {
        if (movieEvent.getType() == 1) {
            System.out.println("ViewerA: " + "cry...");
        }
    }

}
