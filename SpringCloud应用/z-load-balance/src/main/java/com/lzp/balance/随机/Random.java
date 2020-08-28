package com.lzp.balance.随机;

import com.lzp.balance.constant.ServerIps;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class Random {

    //======负载均衡算法实现的方法
    public static String getServer() {
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(ServerIps.LIST.size());
        return ServerIps.LIST.get(randomPos);
    }

    //======测试连续调用十次
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }

}
