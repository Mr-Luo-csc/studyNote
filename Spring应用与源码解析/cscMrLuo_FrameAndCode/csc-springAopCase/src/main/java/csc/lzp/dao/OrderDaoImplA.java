package csc.lzp.dao;

import org.springframework.stereotype.Component;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Component
public class OrderDaoImplA implements OrderDao {

    public void query() {
        System.out.println("AAA");
    }

}
