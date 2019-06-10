package site.yangpan.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyZuulFilter
 * Created by yangpan on 2019-06-10 11:34.
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        logger.info("yangpan-zuul => 执行了filterType()");
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        logger.info("yangpan-zuul => 执行了filterOrder()");
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        logger.info("yangpan-zuul => 执行了shouldFilter()");
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("zuul过滤器拦截到token等于null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                HttpServletResponse response = ctx.getResponse();
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("zuul过滤器拦截到token等于null");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
