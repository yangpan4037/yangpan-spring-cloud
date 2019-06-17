package site.yangpan.hystrix.turbin.feign;

        import org.springframework.stereotype.Component;

/**
 * ScheduleFeignClientHystrix 实现 ScheduleFeignClient接口，它实现的具体方法就是熔断的方法
 * Created by yangpan on 2019-06-17 20:50.
 */
@Component
public class ScheduleFeignClientHystrix implements ScheduleFeignClient {
    @Override
    public String callEurekaClientService() {
        return "通过Feign调用服务出现错误！！Hystrix进行了熔断。";
    }
}
