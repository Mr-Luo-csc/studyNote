package com.lzp.balance.随机;


import com.lzp.balance.constant.ServerIps;

import java.util.Random;

/**
 * @Description: 权重随机算法方式二优化
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
//todo 根据权重来分区间
public class WeightRandomV2 {

    public static String getServer() {
        int totalWeight = 0;
        boolean sameWeight = true;//如果权重相同,随机一个ip就好了
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();

        for (int i = 0; i < weights.length; i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;

            //连续的两个权重是否相等
            //todo 如果相等,不会进if,如果已经是false(也就是修改之后),以后的循环都不会进if
            //todo 以下考虑的是: 权重都相等的情况
            if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
                sameWeight = false;
            }
        }

        System.out.println("总权重: " + totalWeight);
        Random random = new Random();
        int randomPos = random.nextInt(totalWeight);
        System.out.println("随机权重: " + randomPos);

        if (!sameWeight) {
            for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
                //value代表权重
                Integer value = ServerIps.WEIGHT_LIST.get(ip);
                System.out.println("当前IP对应的权重: " + value);
                //当前ip对应的权重 大于 随机的权重的话 直接返回当前的ip地址
                if (randomPos < value) {
                    return ip + "===============权重不相等的情况==============";
                }
                randomPos = randomPos - value;
            }
        }

        String result = (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new Random().nextInt(ServerIps.WEIGHT_LIST.size())];
        return result + "==============权重相等的情况===============";
    }

    /******************************/
    /** -----5---8--10   一个7进来 */
    /** 7<5? false => 7-5=2       */
    /** 2<5? true => return       */
    /******************************/
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
