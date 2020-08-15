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

    //-------------key对应bean实例名称 value对应bean实例对象--------------//
    @Autowired
    private Map<String, OrderDao> map;

    public void query(String userName) {
        //输出一下map中的值
        System.out.println("Map中存在的bean实例: " + map);

        for (String key : map.keySet()) {
            //根据用户类型去map中拿想要的bean实例
            if (key.equals(userName)) {
                OrderDao orderDao = map.get(key);
                //执行dao中查询操作
                orderDao.query();
            }
        }
    }

}
