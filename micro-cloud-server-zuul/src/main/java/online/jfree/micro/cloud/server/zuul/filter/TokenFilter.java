package online.jfree.micro.cloud.server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/8 14:27
 * @since 1.0
 */
@Component
public class TokenFilter extends ZuulFilter {

    public static final String CHECK_ZUUL_TOKEN = "Check-Zuul-Token";

    public static final String ZUUL_TOKEN = "Zuul-Token";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
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
            cxt.setResponseStatusCode(200);
            cxt.setSendZuulResponse(true);
            throw new ZuulRuntimeException(new ZuulException(ZUUL_TOKEN, 401, ""));
        }
        return null;
    }
}
