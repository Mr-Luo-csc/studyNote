package com.lzp.balance.轮训.util;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/28
 **/
//todo IP、weight固定不变的原始权重、currentWeight当前会变化的权重
public class Weight {

    private String ip;
    private Integer weight;
    private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
