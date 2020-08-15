package csc.lzp.handwrite.event;

/**
 * @Description: 电影事件
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class MovieEvent {//时间、地点、任务、环境...

    //todo 拿到事件源,用这个案例来说,我们的事件源指的是电影[被观察者]---这里是抽象出来的,可以多理解
    Object source;

    public MovieEvent(Object source) {
        this.source = source;
    }

    private String content;

    private int type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
