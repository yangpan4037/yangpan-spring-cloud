package site.yangpan.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 这里@EnableDiscoveryClient 注解表示开启服务发现
 * 当前版本默认会开启该注解，可以不加该注解
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ZookeeperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerApplication.class, args);
    }

}
