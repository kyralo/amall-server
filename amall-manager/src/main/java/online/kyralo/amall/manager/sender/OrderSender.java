//package online.kyralo.amall.manager.sender;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Nullable;
//import javax.annotation.Resource;
//import java.util.Objects;
//
///**
// * \* Created with Intellij IDEA.
// * \* Author: wangchen
// * \* Date: 2020/10/3
// * \* Time: 8:36
// * \* Description: 订单发送
// * \
// */
//@Slf4j
//@Component
//public class OrderSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
//
//    @Resource
//    private RabbitTemplate template;
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//        log.info("confirm: {}, s={}, b={}", Objects.requireNonNull(correlationData).toString(), s, b);
//    }
//
//    @Override
//    public void returnedMessage(@Nullable Message message,
//                                int i,
//                                @Nullable String s,
//                                @Nullable String s1,
//                                @Nullable String s2) {
//        log.info("message: {}", JSON.toJSONString(Objects.requireNonNull(message).getBody()));
//    }
//}
