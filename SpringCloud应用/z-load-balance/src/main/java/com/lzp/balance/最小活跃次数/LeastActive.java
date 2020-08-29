package com.lzp.balance.最小活跃次数;

import com.lzp.balance.constant.ServerIps;

import java.util.*;

/**
 * @Description: 最小活跃次数
 * @Author: luozhipeng
 * @Date: 2020/8/29
 **/
public class LeastActive {


    public static String getServer() {

        //获取当前活跃数最小的服务器
        Optional<Integer> minValue = ServerIps.ACTIVITY_LIST.values().stream().min(Comparator.naturalOrder());

        //todo isPresent是否存在,Java中判断null的几种方式
        if (minValue.isPresent()) {
            List<String> minActivityIps = new ArrayList<>();
            ServerIps.ACTIVITY_LIST.forEach((ip, activity) -> {
                if (activity.equals(minValue.get())) {
                    minActivityIps.add(ip);
                }
            });

            //最小活跃数的IP有多少个,则根据权重来选,权重大的优先
            if (minActivityIps.size() > 1) {
                //过滤出对应的IP和权重
                Map<String, Integer> weightList = new LinkedHashMap<>();
                //todo
               /* ServerIps.WEIGHT_LIST.forEach(() -> {

                });*/
            }
        }


        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }

}
