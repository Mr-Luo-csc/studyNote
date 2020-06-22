package csc.lzp.service;

import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/22
 **/
@Service
public class GoodService {

    public GoodService() {
        System.out.println("bean容器中拿到goodService");
    }

}
