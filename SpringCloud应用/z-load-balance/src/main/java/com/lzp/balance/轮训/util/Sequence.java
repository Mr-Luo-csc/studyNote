package com.lzp.balance.轮训.util;

/**
 * @Description: 模拟调用编号获取工具
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class Sequence {

    public static Integer num = 0;

    //======取值并且自增
    public static Integer getAndIncrement() {
        return ++num;
    }
}
