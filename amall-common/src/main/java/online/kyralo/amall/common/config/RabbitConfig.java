package online.kyralo.amall.common.config;//package com.zzb.common.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* @author: WangChen
// * \* Date: 19-9-22
// * \* Time: 下午3:25
// * \
// */
//@EnableRabbit
//@Configuration
//public class RabbitConfig {
//
//    //持有化构建
//    /**
//     * 持有化
//     * 管理员queue
//     */
//    @Bean("ADMIN")
//    public Queue adminQueue(){
//        return QueueBuilder.durable("Topic.ADMIN").build();
//    }
//
//    /**
//     * 持有化
//     * 用户queue
//     */
//    @Bean("USER")
//    public Queue userQueue(){
//        return QueueBuilder.durable("Topic.USER").build();
//    }
//
//    /**
//     * 持有化
//     * 农户queue
//     */
//    @Bean("FARMER")
//    public Queue farmerQueue(){
//        return QueueBuilder.durable("Topic.FARMER").build();
//    }
//
//
//    /**
//     * 声明Topic交换机 支持持久化.
//     */
//    @Bean("TopicExchange")
//    public TopicExchange topicExchange(){
//        return (TopicExchange) ExchangeBuilder.topicExchange("Topic").durable(true).build();
//    }
//
//    /**
//     * 把adminQueue绑定到TopicExchange
//     */
//    @Bean("AdminBinding")
//    public Binding adminBinding(@Qualifier("ADMIN") Queue queue,@Qualifier("TopicExchange") TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with("*.ADMIN");
//    }
//
//    /**
//     * 把userQueue绑定到TopicUserExchange
//     */
//    @Bean("UserBinding")
//    public Binding userBinding(@Qualifier("USER") Queue queue,@Qualifier("TopicExchange") TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with("*.USER");
//    }
//
//    /**
//     * 把farmerQueue绑定到TopicFarmerExchange
//     */
//    @Bean("FarmerBinding")
//    public Binding farmerBinding(@Qualifier("FARMER") Queue queue,@Qualifier("TopicExchange") TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with("*.FARMER");
//    }
//
//    /**
//     * 更改消息队列的默认序列化方式
//     */
//    @Bean
//    public MessageConverter messageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//
//}
