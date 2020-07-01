package csc.lzp.dao;

import org.springframework.stereotype.Repository;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/1
 **/
@Repository
public class IndexDao1 implements Dao {

    public IndexDao1() {
        System.out.println("indexDao1的无参构造方法,不用每次使用getBean的时候都去new,Spring中的bean都是单例的");
    }

    public String query() {
        System.out.println("IndexDao1模拟查询数据库");
        return "key_l";
    }

}
