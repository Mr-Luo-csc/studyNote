package com.lzp.balance.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       /* WEIGHT_LIST.put("192.168.0.1", 1);
        WEIGHT_LIST.put("192.168.0.2", 9);
        WEIGHT_LIST.put("192.168.0.3", 2);
        WEIGHT_LIST.put("192.168.0.4", 8);
        WEIGHT_LIST.put("192.168.0.5", 3);
        WEIGHT_LIST.put("192.168.0.6", 7);
        WEIGHT_LIST.put("192.168.0.7", 6);
        WEIGHT_LIST.put("192.168.0.8", 4);
        WEIGHT_LIST.put("192.168.0.9", 5);
        WEIGHT_LIST.put("192.168.0.10", 5)*/;

        WEIGHT_LIST.put("A", 5);
        WEIGHT_LIST.put("B", 1);
        WEIGHT_LIST.put("C", 1);
    }

}
