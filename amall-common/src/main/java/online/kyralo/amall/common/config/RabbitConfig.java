//package online.kyralo.amall.common.config;//package com.zzb.common.config;
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
// * \* Author: WangChen
// */
//@EnableRabbit
//@Configuration
//public class RabbitConfig {
//
//    //持有化构建
//    /**
//     * 持有化
//     * 订单queue
//     */
//    @Bean("ORDER")
//    public Queue orderQueue(){
//        return QueueBuilder.durable("Topic.ADMIN").build();
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
//     * 把orderQueue绑定到TopicExchange
//     */
//    @Bean("orderBinding")
//    public Binding orderBinding(@Qualifier("ORDER") Queue queue,@Qualifier("TopicExchange") TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with("*.ORDER");
//    }
//
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
