package online.jfree.micro.cloud.service.order.api;

import online.jfree.micro.cloud.service.order.entity.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: ${todo}
 * @author: Guo Lixiao
 * @date 2018/5/21 15:25
 * @since 1.0
 */
@RestController
public class OrderController {

    Logger logger =  LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/order")
    public OrderDTO getOrdersByUserId(@RequestParam("userId") String userId){
        logger.info("order service userId: {}", userId);
        OrderDTO order = new OrderDTO();
        order.setId("test001");
        order.setName("订单0001");
        order.setMoney(100.01);
        return order;
    }

}
