package site.yangpan.zookeeper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册到zookeeper的服务接口
 * Created by yangpan on 2020-08-30 22:49.
 */
@RestController
@RequestMapping("/zookeeperServer")
public class ZookeeperServerController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String prot;

    @GetMapping("/test")
    public String test(){
        return "当前应用是：" + name + "端口是：" + prot;
    }

}
