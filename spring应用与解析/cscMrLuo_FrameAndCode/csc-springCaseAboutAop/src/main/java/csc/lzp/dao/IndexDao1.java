package csc.lzp.dao;

import org.springframework.stereotype.Component;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/24
 **/
@Component
public class IndexDao1 implements Dao{

    public void query() {
        System.out.println("this is index1");
    }

}
