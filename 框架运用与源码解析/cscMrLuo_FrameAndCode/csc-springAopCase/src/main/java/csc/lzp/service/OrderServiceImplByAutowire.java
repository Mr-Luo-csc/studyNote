package csc.lzp.service;

import csc.lzp.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Discription: 这里@autowired可以导入实现相同接口的bean,用map来储存
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Service
public class OrderServiceImplByAutowire {

    @Autowired
    private Map<String, OrderDao> map;

    public void query() {
        System.out.println("service层的查询订单方法");
        System.out.println(map);
    }

}
