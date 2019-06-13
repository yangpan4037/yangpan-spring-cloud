package site.yangpan.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigController
 * Created by yangpan on 2019-06-11 15:35.
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${yangpan.name}")
    private String name;

    @Value("${yangpan.age}")
    private String age;

    @Value("${yangpan.fileName}")
    private String fileName;

    @RequestMapping("/client")
    public String port(){
        return "Spring Cloud Config Client 从 Spring Cloud Config Server 读取 git：文件名："+ fileName +", 姓名：" + name + "，年龄：" + age;
    }
}
