package com.lzp.balance.轮训;

import com.lzp.balance.constant.ServerIps;

/**
 * @Description: 轮训算法的实现
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class RoundRobin {

    //记录当前循环位置
    private static Integer pos = 0;

    public static String getServer() {

        String ip = null;
        //同步
        synchronized (pos) {
            if (pos >= ServerIps.LIST.size()) {
                pos = 0;
            }
            ip = ServerIps.LIST.get(pos);

            pos++;
        }
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }

}
