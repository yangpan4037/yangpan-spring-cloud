package site.yangpan.eureka.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterServerApplication.class, args);
    }

}
