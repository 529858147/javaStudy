package com.how2j.commonUtil;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/13 13:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ZookeeperConfigTest {
    @Autowired
    private ZookeeperConfig zookeeperConfig;
    @Autowired
    private ZkApi zkApi;

    @Test
    void zkClient() {
        zookeeperConfig.zkClient();
    }

    @Test
    void zkApi() {
        zookeeperConfig.zkClient();
        zkApi.createNode("/test-20220213", "test");
        System.out.println(zkApi.getData("/test-20220213", null));
    }
}