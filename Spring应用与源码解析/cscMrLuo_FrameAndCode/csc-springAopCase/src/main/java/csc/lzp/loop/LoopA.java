package csc.lzp.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/20
 **/
@Component
public class LoopA {

    @Autowired
    private LoopB loopB;

}
