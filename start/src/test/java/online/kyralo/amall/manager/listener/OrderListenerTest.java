package online.kyralo.amall.manager.listener;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static online.kyralo.amall.common.constants.RabbitmqConstant.QUEUE_ORDER;

@SpringBootTest
class OrderListenerTest {

    @Resource
    private RabbitTemplate template;

    @Test
    void orderNotice() {

        try {
            template.convertAndSend(QUEUE_ORDER, "hello i get it");
        } catch (AmqpException e) {
            System.out.println("-->>->>->>-- e - r - r - o - r -->>->>->>");
        }


    }
}