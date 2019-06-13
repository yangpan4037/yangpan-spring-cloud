package site.yangpan.bus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringCloudBusController
 * Created by yangpan on 2019-06-12 16:49.
 */
@RestController
@RequestMapping("/bus")
@RefreshScope
public class SpringCloudBusController {

    @Value("${yangpan.name}")
    private String name;

    @Value("${yangpan.age}")
    private String age;

    @Value("${yangpan.fileName}")
    private String fileName;

    @RequestMapping("/readConfig")
    public String port(){
        return "【Spring Cloud Bus + Spring Cloud Config Client】 从 Spring Cloud Config Server 读取 git：文件名："+ fileName +", 姓名：" + name + "，年龄：" + age;
    }

}
