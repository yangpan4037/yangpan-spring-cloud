package site.yangpan.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.feign.feign.ScheduleFeignClient;

/**
 * FeignController
 * Created by yangpan on 2019-06-06 11:08.
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private ScheduleFeignClient scheduleFeignClient;

    @GetMapping("/call")
    public String call(){
        String result = scheduleFeignClient.callEurekaClientService();
        return "通过Feign调用 => " + result;
    }

}
