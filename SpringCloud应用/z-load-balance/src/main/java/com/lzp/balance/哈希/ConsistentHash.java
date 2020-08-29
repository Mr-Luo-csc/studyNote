package com.lzp.balance.哈希;

import com.lzp.balance.constant.ServerIps;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description: 一致性哈希算法
 * @Author: luozhipeng
 * @Date: 2020/8/29
 **/
//todo 使用的场景:固定session的访问(到同一台服务器中拿session;实现与服务器绑定)
public class ConsistentHash {

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    private static final int VIRTUAL_NODES = 10;

    static {
        //对每个真实节点添加虚拟节点,虚拟节点会根据哈希算法进行散列
        for (String ip : ServerIps.LIST) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHash(ip + "VN" + i);
                virtualNodes.put(hash, ip);
            }
        }
    }

    //======随机生成一个hash值的方法
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        //负数取绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    private static String getServer(String client) {
        int hash = getHash(client);
        //得到大于该hash值的排好序的Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        //大于该hash值的第一个元素的位置
        Integer nodeIndex = subMap.firstKey();
        //如果不存在大于该hash值的元素,则返回根结点
        if (nodeIndex == null) {
            nodeIndex = virtualNodes.firstKey();
        }
        //返回对应的虚拟节点名称
        return virtualNodes.get(nodeIndex);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer("clientServer" + i));
        }
    }
}
