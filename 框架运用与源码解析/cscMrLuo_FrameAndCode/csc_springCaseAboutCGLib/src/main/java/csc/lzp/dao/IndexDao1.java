package csc.lzp.dao;

import org.springframework.stereotype.Repository;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/1
 **/
@Repository
public class IndexDao1 implements Dao {

    public String query() {
        System.out.println("IndexDao1模拟查询数据库");
        return "key_l";
    }

}
