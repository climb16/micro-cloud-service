package online.jfree.micro.cloud.service.user.api;

import online.jfree.micro.cloud.service.user.entity.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Guo Lixiao
 * @date: 2017-12-14 13:56
 * @see:
 * @since:
 **/
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/user")
    public String getUser() {
        return "{userId:1, userName:'test', appname: }";
    }

    @GetMapping(value = "/user/order")
    public OrderDTO getUserOrder(@RequestParam("userId") String userId) {
        ResponseEntity<OrderDTO> responseEntity =  restTemplate.getForEntity("http://SERVICE-ORDER/order?userId=" + userId, OrderDTO.class);
        OrderDTO order = responseEntity.getBody();
        logger.info(order.toString());
        return order;
    }
}
