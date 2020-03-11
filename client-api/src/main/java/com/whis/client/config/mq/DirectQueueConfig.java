package com.whis.client.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: carl
 * @Date: 2020-01-15 21:03
 */
@Configuration
public class DirectQueueConfig {

    public static final String DIR_QUEUE = "direct";

    @Bean
    public Queue dirQueue() {
        return new Queue(DIR_QUEUE);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    Binding bindingDirect(@Qualifier("dirQueue") Queue dirQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(dirQueue).to(directExchange).with("direct");
    }
}
