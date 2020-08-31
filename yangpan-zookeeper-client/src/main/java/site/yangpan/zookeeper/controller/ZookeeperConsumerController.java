package site.yangpan.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.zookeeper.feign.ZookeeperServerFeignClient;

/**
 * 注册到zookeeper的服务消费端接口
 * Created by yangpan on 2020-08-30 22:58.
 */
@RestController
@RequestMapping("/zookeeperConsumer")
public class ZookeeperConsumerController {

    @Autowired
    private ZookeeperServerFeignClient zookeeperServerFeignClient;

    @GetMapping("/callZookeeperServer")
    public String callZookeeperServer(){
        return zookeeperServerFeignClient.callZookeeperServer();
    }
}
