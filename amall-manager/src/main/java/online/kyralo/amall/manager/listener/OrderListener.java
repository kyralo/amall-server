//package online.kyralo.amall.manager.listener;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//import static online.kyralo.amall.common.constants.RabbitmqConstant.QUEUE_ORDER;
//
///**
// * \* Created with Intellij IDEA.
// * \* @author: wangchen
// * \* Date: 2020/7/11
// * \* Time: 22:14
// * \* Description: 订单 消息队列监听  [幂等处理]
// * \
// */
//
//@Slf4j
//@Component
//public class OrderListener {
//
//    /**
//     * 订单 下单
//     */
//    @RabbitListener(queues = QUEUE_ORDER)
//    public void orderNoticePlace(@Payload String body, @Headers Map<String,Object> headers) {
//        log.info(" --- start --- ");
//
//        log.info(body);
//
//        log.info(" ---  end --- ");
//    }
//
//    /**
//     * 订单 减库存
//     */
//    @RabbitListener(queues = QUEUE_ORDER)
//    public void orderNoticeReduce(@Payload String body) {
//        log.info(" --- start --- ");
//
//        log.info(body);
//
//        log.info(" ---  end --- ");
//    }
//
//    /**
//     * 订单 回调通知 [ websocket 全双工监听 ]
//     */
//    @RabbitListener(queues = QUEUE_ORDER)
//    public void orderNoticeCallback(@Payload String body) {
//        log.info(" --- start --- ");
//
//        log.info(body);
//
//        log.info(" ---  end  --- ");
//    }
//}
