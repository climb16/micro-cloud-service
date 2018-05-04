package online.jfree.micro.cloud.service.user.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Guo Lixiao
 * @date: 2017-12-14 13:56
 * @see:
 * @since:
 **/
@RefreshScope
@RestController
public class UserController {

    @Value("${from}")
    String instanceId;

    @GetMapping(value = "/user")
    public String getUser() {
        return "{userId:1, userName:'test', appname: " + instanceId + "}";
    }
}
