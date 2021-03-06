package site.yangpan.hystrix.turbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.hystrix.turbin.feign.ScheduleFeignClient;

/**
 * HystrixFeignController
 * Created by yangpan on 2019-06-17 20:55.
 */
@RestController
@RequestMapping("/hystrixFeign")
public class HystrixFeignController {

    @Autowired
    private ScheduleFeignClient scheduleFeignClient;

    @GetMapping("/call")
    public String call(){
        String result = scheduleFeignClient.callEurekaClientService();
        return "通过Feign调用 => " + result;
    }
}
