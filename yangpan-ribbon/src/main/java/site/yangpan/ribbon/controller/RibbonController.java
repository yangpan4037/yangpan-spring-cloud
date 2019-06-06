package site.yangpan.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * RibbonController
 * Created by yangpan on 2019-06-05 16:03.
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/call")
    public String call(){
        String result = restTemplate.getForObject("http://yangpan-eureka-client/test", String.class);
        return "通过Ribbon + RestTemplate调用 => " + result;
    }

}
