package csc.lzp.dao;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/1
 **/
public class IndexDao2 implements Dao {

    public String query() {
        System.out.println("IndexDao2模拟查询数据库");
        return "kongFuPang";
    }

}
