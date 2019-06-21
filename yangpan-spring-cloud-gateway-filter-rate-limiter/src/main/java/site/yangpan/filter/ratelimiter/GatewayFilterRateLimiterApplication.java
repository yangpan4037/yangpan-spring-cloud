package site.yangpan.filter.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import site.yangpan.filter.ratelimiter.resolver.HostAddrKeyResolver;
import site.yangpan.filter.ratelimiter.resolver.UriKeyResolver;

@SpringBootApplication
public class GatewayFilterRateLimiterApplication {

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterRateLimiterApplication.class, args);
    }

}
