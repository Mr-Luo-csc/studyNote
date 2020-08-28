package com.lzp.balance.轮训;

import com.lzp.balance.constant.ServerIps;
import com.lzp.balance.轮训.util.Sequence;

/**
 * @Description: 轮训算法+权重处理
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class WeightRoundRobin {

    private static Integer pos = 0;

    public static String getServer() {

        int totalWeight = 0;
        boolean sameWeight = true;
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();

        //看是否有相同的权重的情况
        for (int i = 0; i < weights.length; i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;
            if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
                sameWeight = false;
            }
        }

        Integer sequenceNum = Sequence.getAndIncrement();
        Integer offset = sequenceNum % totalWeight;

        offset = offset == 0 ? totalWeight : offset;//todo 取模0的情况

        if (!sameWeight) {
            for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
                Integer weight = ServerIps.WEIGHT_LIST.get(ip);
                if (offset <= weight) {
                    return ip;
                }
                offset = offset - weight;
            }
        }

        //todo 权重相等走的逻辑
        String ip = null;

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
