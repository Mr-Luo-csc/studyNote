package com.lzp.balance.随机;


import com.lzp.balance.constant.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: 权重随机算法
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class WeightRandom {

    public static String getServer() {
        //todo 这种方式比较消耗内存
        List<String> ips = new ArrayList<>();

        for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);

            //按照权重进行复制
            for (int i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(ips.size());

        return ips.get(randomPos);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
