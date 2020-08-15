package csc.lzp.handwrite.monitor;

import csc.lzp.handwrite.event.MovieEvent;

/**
 * @Description: 电影监听器
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public interface MonitorListener {

    /**
     * 监听者,接收到事件后,触发的方法
     */
    void update(MovieEvent movieEvent);
}
