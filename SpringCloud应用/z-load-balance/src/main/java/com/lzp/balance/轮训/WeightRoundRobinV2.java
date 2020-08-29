package com.lzp.balance.轮训;

import com.lzp.balance.constant.ServerIps;
import com.lzp.balance.轮训.util.Weight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 平滑加权轮训
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class WeightRoundRobinV2 {

    private static Map<String, Weight> weightMap = new HashMap<>();


    public static String getServer() {

        int totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0, (w1, w2) -> w1 + w2);

        //初始化weightMap,初始时将currentWeight赋值为weight
        if (weightMap.isEmpty()) {
            ServerIps.WEIGHT_LIST.forEach((key, value) -> {
                weightMap.put(key, new Weight(key, value, value));
            });
        }

        //找出currentWeight的最大值
        Weight maxCurrentWeight = null;
        for (Weight weight : weightMap.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }

        //将maxCurrentWeight减去总权重和
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalWeight);

        //所有的IP的currentWeight统一加上原始权重
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        //返回maxCurrentWeight所对应的IP
        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }

}
