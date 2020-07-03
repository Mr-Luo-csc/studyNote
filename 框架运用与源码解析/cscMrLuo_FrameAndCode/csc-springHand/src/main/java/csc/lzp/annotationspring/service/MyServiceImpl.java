package csc.lzp.annotationspring.service;

import csc.lzp.annotationspring.anno.MyServiceAnnotate;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/31
 **/
@MyServiceAnnotate("myServiceImpl")
public class MyServiceImpl {

    public MyServiceImpl() {
        System.out.println("你已经拿到了当前这个对象!");
    }

}
