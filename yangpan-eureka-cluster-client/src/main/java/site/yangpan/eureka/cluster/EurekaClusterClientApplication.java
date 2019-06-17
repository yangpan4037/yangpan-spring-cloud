package site.yangpan.eureka.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClusterClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClusterClientApplication.class, args);
    }

}
