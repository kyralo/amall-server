package online.kyralo.amall.common.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: WangChen
 */
@Slf4j
@EnableRabbit
@Configuration
public class RabbitConfig {

    //持有化构建

    /**
     * 持有化
     * 订单queue
     */
    @Bean("order")
    public Queue orderQueue() {
        return QueueBuilder.durable("direct.order.user").build();
    }

    /**
     * 声明Direct交换机 支持持久化.
     */
    @Bean("orderDirectExchange")
    public DirectExchange directExchange() {
        return (DirectExchange) ExchangeBuilder.directExchange("direct.order").durable(true).build();
    }

    /**
     * 把 Queue 绑定到 Exchange
     */
    @Bean("orderBinding")
    public Binding orderBinding(@Qualifier("order") Queue queue,
                                @Qualifier("orderDirectExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with("direct.order.user");
    }

    /**
     * 更改消息队列的默认序列化方式
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

//    @Primary
//    @Bean
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(messageConverter());
//        //开启手动 ack
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//
//        return factory;
//    }

//     全局处理消息 [ 心跳确认 ]

//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        // 监听的队列
//        container.setQueueNames("direct.order.user");
//        // 手动确认
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        //消息处理
//        container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {
//            log.info("====接收到消息=====");
//            log.info(new String(message.getBody()));
//            if(message.getMessageProperties().getHeaders().get("error") == null){
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                log.info("消息已经确认");
//            }else {
//                // channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false)
//                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
//                log.info("消息拒绝");
//            }
//
//        });
//        return container;
//    }

}
