package site.yangpan.zookeeper.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用注册到zookeeper的服务客户端
 * Created by yangpan on 2020-08-30 22:55.
 */
@FeignClient("yangpan-zookeeper-server")
public interface ZookeeperServerFeignClient {
    /**
     * 方法上的注解可以使用 @GetMapping、@PostMapping
     * 方法的参数也可以使用 @RequestBody、@RequestParam
     * 总之与其他的controller写法一致
     */
    @RequestMapping("/zookeeperServer/test")
    String callZookeeperServer();
}
