package site.yangpan.gateway.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayRouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayRouteApplication.class, args);
    }

}
