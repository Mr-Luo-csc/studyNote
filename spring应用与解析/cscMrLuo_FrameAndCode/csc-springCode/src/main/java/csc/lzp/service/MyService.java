package csc.lzp.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/28
 **/
@Service
@Scope(value = "singleton")
public class MyService {

    public MyService() {
        System.out.println("自定义service层");
    }

}
