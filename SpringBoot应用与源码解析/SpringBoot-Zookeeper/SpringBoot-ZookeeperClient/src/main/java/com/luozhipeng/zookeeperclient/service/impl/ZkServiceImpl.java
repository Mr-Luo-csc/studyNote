package com.luozhipeng.zookeeperclient.service.impl;

import com.luozhipeng.zookeeperclient.service.ZkService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: luozhipeng
 * @description:
 * @data: 2020-09-25
 **/
@Service
public class ZkServiceImpl implements ZkService {

    @Override
    public Stat exists(String path, boolean needWatch) {
        return null;
    }

    @Override
    public Stat exists(String path, Watcher watcher) {
        return null;
    }

    @Override
    public boolean createNode(String path, String data) {
        return false;
    }

    @Override
    public boolean updateNode(String path, String data) {
        return false;
    }

    @Override
    public boolean deleteNode(String path) {
        return false;
    }

    @Override
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        return null;
    }

    @Override
    public String getData(String path, Watcher watcher) {
        return null;
    }
}
