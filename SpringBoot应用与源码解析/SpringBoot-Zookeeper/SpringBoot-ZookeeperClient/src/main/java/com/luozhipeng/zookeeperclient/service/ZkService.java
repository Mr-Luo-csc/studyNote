package com.luozhipeng.zookeeperclient.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author: luozhipeng
 * @description: zookeeper封装工具类
 * @data: 2020-09-25
 **/
public interface ZkService {
    /**
     * 判断指定节点是否存在
     * needWatch 指定是否复用zookeeper中默认的Watcher
     */
    Stat exists(String path, boolean needWatch);

    /**
     * 检测结点是否存在 并设置监听事件
     * 三种监听类型：创建，删除，更新
     */
    Stat exists(String path, Watcher watcher);

    /**
     * 创建持久化节点
     */
    boolean createNode(String path, String data);

    /**
     * 修改持久化节点
     */
    boolean updateNode(String path, String data);

    /**
     * 删除持久化节点
     */
    boolean deleteNode(String path);

    /**
     * 获取当前节点的子节点(不包含孙子节点)
     */
    List<String> getChildren(String path) throws KeeperException, InterruptedException;

    /**
     * 获取指定节点的值
     */
    String getData(String path, Watcher watcher);
}
