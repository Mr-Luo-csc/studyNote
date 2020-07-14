package csc.lzp.model;

import org.springframework.stereotype.Component;

/**
 * @Discription: 用户
 * @Author: luozhipeng
 * @Date: 2020/7/14
 **/
@Component
public class UserClazz {

    OrderClazz orderClazz;

    public OrderClazz getOrderClazz() {
        return orderClazz;
    }

    public void setOrderClazz(OrderClazz order) {
        this.orderClazz = order;
    }

}
