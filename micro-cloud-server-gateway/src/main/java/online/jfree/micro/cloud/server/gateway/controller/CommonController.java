package online.jfree.micro.cloud.server.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author: Guo Lixiao
 * @date 2018-7-16 18:42
 * @since 1.0
 */
@RestController
public class CommonController {

    @RequestMapping(value = "/fallback")
    public Mono fallback(){
        return Mono.just("{\"code\": 404}");
    }
}
