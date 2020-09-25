package com.luozhipeng.zookeeperclient.controller;

import com.luozhipeng.zookeeperclient.service.ZkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: luozhipeng
 * @description: 调用方法测试
 * @data: 2020-09-25
 **/
@RestController
public class ZookeeperClientController {

    @Autowired
    private ZkService zkService;

    //todo

}
