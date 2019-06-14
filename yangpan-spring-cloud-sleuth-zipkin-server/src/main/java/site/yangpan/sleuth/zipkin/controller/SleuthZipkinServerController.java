package site.yangpan.sleuth.zipkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * SleuthZipkinController
 * Created by yangpan on 2019-06-14 15:03.
 */
@RestController
@RequestMapping("/sleuthZipkinServer")
public class SleuthZipkinServerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/call")
    public String callHome() {
        return restTemplate.getForObject("http://localhost:8989/sleuthZipkinClient/info", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        return "i'm yangpan-spring-cloud-sleuth-zipkin-server,我被其他服务被调用了！";
    }

}
