package site.yangpan.gateway.filter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 * Created by yangpan on 2019-06-20 16:27.
 */
public class GlobalTokenFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(GlobalTokenFilter.class);

    /**
     * 过滤方法
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            logger.info("全局过滤器：token is empty...，不会执行后面的自定义过滤器。。");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    /**
     * 给过滤器设定优先级别,值越大则优先级越低
     * @return
     */
    @Override
    public int getOrder() {
        return -100;
    }
}
