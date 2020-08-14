package csc.lzp.event;

/**
 * @Description: 电影事件
 * @Author: luozhipeng
 * @Date: 2020/8/14
 **/
public class MovieEvent {//时间、地点、任务、环境...

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
