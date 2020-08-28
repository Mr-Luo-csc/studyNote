package com.lzp.balance.随机;


import com.lzp.balance.constant.ServerIps;

import java.util.Random;

/**
 * @Description: 权重随机算法方式二优化
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class WeightRandomV2 {

    public static String getServer() {
        int totalWeight = 0;
        boolean sameWeight = true;//如果权重相同,随机一个ip就好了
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();

        for (int i = 0; i < weights.length; i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;

            if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
                sameWeight = false;
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(totalWeight);

        if (!sameWeight) {
            for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
                Integer value = ServerIps.WEIGHT_LIST.get(ip);

                if (randomPos < value) {
                    return ip;
                }
                randomPos = randomPos - value;
            }
        }

        String result = (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new Random().nextInt(ServerIps.WEIGHT_LIST.size())];
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
