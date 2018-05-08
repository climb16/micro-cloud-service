package online.jfree.micro.cloud.server.zuul.filter;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/8 14:31
 * @since 1.0
 */
public interface ZuulFilterType {

    String PRE      =   "pre";

    String POST     =   "post";

    String ROUTE    =   "route";

    String ERROR    =   "error";
}
