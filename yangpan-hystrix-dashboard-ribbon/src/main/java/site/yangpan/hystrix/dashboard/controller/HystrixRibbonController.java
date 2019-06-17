package site.yangpan.hystrix.dashboard.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * HystrixRibbonController
 * Created by yangpan on 2019-06-17 16:07.
 */
@RestController
@RequestMapping("/hystrixRibbon")
public class HystrixRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand注解标明了fallbackMethod熔断方法
     */
    @RequestMapping("/call")
    @HystrixCommand(fallbackMethod = "callError")
    public String call(){
        String result = restTemplate.getForObject("http://yangpan-eureka-client/test", String.class);
        return "通过Ribbon + RestTemplate调用 => " + result;
    }

    public String callError(){
        return "通过Ribbon + RestTemplate调用服务出现错误！！";
    }
}
