package online.jfree.micro.cloud.server.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/9 18:14
 * @since 1.0
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableDiscoveryClient
public class OAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}
