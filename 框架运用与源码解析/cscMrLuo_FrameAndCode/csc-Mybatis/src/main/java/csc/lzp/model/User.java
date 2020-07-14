package csc.lzp.model;

import org.springframework.stereotype.Component;

/**
 * @Discription: 用户
 * @Author: luozhipeng
 * @Date: 2020/7/14
 **/
@Component
public class UserClazz {

    Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
