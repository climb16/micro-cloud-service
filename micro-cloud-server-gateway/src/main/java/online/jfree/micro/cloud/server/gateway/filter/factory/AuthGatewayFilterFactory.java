package online.jfree.micro.cloud.server.gateway.filter.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Guo Lixiao
 * @date 2018-7-25 18:35
 * @since 1.0
 */
@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    public AuthGatewayFilterFactory(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.enable == true) {
                ServerHttpRequest request = exchange.getRequest();
                String path = request.getPath().value();
                for (String p : config.ignoresPath) {
                    if (path.startsWith(p)) {
                        return chain.filter(exchange);
                    }
                }
                String token = request.getHeaders().getFirst(config.name);
                if (!config.value.equals(token)) {
                    ServerHttpResponse response = exchange.getResponse();
                    response.setStatusCode(HttpStatus.FORBIDDEN);
                    return response.setComplete();
                }
            }
            return chain.filter(exchange);
        };
    }

    public class Config {
        private boolean enable = false;
        private List<String> ignoresPath = Collections.emptyList();
        private String name = "Token";
        private String value;

        public List<String> getIgnoresPath() {
            return ignoresPath;
        }

        public void setIgnoresPath(List<String> ignoresPath) {
            this.ignoresPath = ignoresPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Config{");
            sb.append("enable=").append(enable);
            sb.append(", ignoresPath=").append(ignoresPath);
            sb.append(", name='").append(name).append('\'');
            sb.append(", value='").append(value).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
