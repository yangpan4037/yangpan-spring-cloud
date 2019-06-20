package site.yangpan.gateway.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import site.yangpan.gateway.filter.filter.GatewayRequestTimeFilter;
import site.yangpan.gateway.filter.filter.GlobalTokenFilter;

@SpringBootApplication
public class GatewayFilterApplication {

    /**
     * 全局过滤器注册到Spring Ioc容器中
     * @return
     */
    @Bean
    public GlobalTokenFilter tokenFilter(){
        return new GlobalTokenFilter();
    }


    /**
     * 定义一个路由，然后使用我们自己的过滤器
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new GatewayRequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
        // @formatter:on
    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }

}
