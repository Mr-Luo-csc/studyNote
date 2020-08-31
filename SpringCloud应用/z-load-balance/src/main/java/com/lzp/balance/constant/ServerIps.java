package com.lzp.balance.constant;

import java.util.*;

/**
 * @Description: 模拟服务器
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
public class ServerIps {

    public static final List<String> LIST = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    );

    public static final Map<String, Integer> WEIGHT_LIST = new HashMap<String, Integer>();

    static {
        WEIGHT_LIST.put("192.168.0.1", 1);
        WEIGHT_LIST.put("192.168.0.2", 9);
        WEIGHT_LIST.put("192.168.0.3", 2);
        WEIGHT_LIST.put("192.168.0.4", 8);
        WEIGHT_LIST.put("192.168.0.5", 3);
        WEIGHT_LIST.put("192.168.0.6", 7);
        WEIGHT_LIST.put("192.168.0.7", 6);
        WEIGHT_LIST.put("192.168.0.8", 4);
        WEIGHT_LIST.put("192.168.0.9", 5);
        WEIGHT_LIST.put("192.168.0.10", 5);

       /* WEIGHT_LIST.put("A", 5);
        WEIGHT_LIST.put("B", 1);
        WEIGHT_LIST.put("C", 1);*/
    }

    public static final Map<String, Integer> ACTIVITY_LIST = new LinkedHashMap<>();

    static {
        ACTIVITY_LIST.put("192.168.0.1", 2);
        ACTIVITY_LIST.put("192.168.0.2", 0);
        ACTIVITY_LIST.put("192.168.0.3", 1);
        ACTIVITY_LIST.put("192.168.0.4", 3);
        ACTIVITY_LIST.put("192.168.0.5", 0);
        ACTIVITY_LIST.put("192.168.0.6", 1);
        ACTIVITY_LIST.put("192.168.0.7", 4);
        ACTIVITY_LIST.put("192.168.0.8", 2);
        ACTIVITY_LIST.put("192.168.0.9", 7);
        ACTIVITY_LIST.put("192.168.0.10", 3);
    }

}
