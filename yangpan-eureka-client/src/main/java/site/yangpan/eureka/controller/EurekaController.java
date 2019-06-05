package site.yangpan.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EurekaController
 * Created by yangpan on 2019-06-05 15:35.
 */
@RestController
@RequestMapping("/test")
public class EurekaController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping
    public String port(){
        return "服务名称: " + name + "，端口号：" + port;
    }
}
