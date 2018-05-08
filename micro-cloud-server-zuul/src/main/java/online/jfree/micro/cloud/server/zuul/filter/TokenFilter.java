package online.jfree.micro.cloud.server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/8 14:27
 * @since 1.0
 */
@Configuration
public class TokenFilter extends ZuulFilter {

    public static final String CHECK_ZUUL_TOKEN = "Check-Zuul-Token";

    public static final String ZUUL_TOKEN = "Zuul-Token";

    @Override
    public String filterType() {
        return ZuulFilterType.PRE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String checkZuulToken = request.getHeader(CHECK_ZUUL_TOKEN);
        if (Boolean.FALSE.toString().equals(checkZuulToken)) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        String zullToken = request.getHeader(ZUUL_TOKEN);
        if (zullToken == null || ("").equals(zullToken.trim())) {
            cxt.setSendZuulResponse(false);
            cxt.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
