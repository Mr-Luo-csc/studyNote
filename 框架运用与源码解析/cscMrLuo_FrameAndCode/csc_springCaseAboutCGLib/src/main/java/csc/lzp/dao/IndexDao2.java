package csc.lzp.dao;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/1
 **/
public class IndexDao2 implements Dao {

    public IndexDao2() {
        System.out.println("indexDao2的无参构造方法,不用每次使用该bean的时候都去new,保证bean是单例的");
    }

    public String query() {
        System.out.println("IndexDao2模拟查询数据库");
        return "kongFuPang";
    }

}
