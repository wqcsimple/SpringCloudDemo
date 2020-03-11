package com.whis.client.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
* 死信队列配置
* @author carl
* @Date 2020-01-15 20:38
*/
@Configuration
public class DelayQueueConfig {

    private static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    private static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    public static final String DL_EXCHANGE = "DL_EXCHANGE";
    private static final String DL_QUEUE = "DL_QUEUE";
    public static final String DL_KEY = "DL_KEY";
    private static final String DL_R_KEY = "KEY_R";

    public static final String REDIRECT_QUEUE = "REDIRECT_QUEUE";

    /**
     * 死信队列交换机
     */
    @Bean
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(DL_EXCHANGE).durable(true).build();
    }

    /**
     * 声明一个死信队列
     */
    @Bean
    public Queue deadLetterQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // 死信交换机
        args.put(DEAD_LETTER_QUEUE_KEY, DL_EXCHANGE);
        // 死信路由键
        args.put(DEAD_LETTER_ROUTING_KEY, DL_R_KEY);
        return QueueBuilder.durable(DL_QUEUE).withArguments(args).build();
    }

    /**
     * 定义死信队列转发队列
     */
    @Bean
    public Queue redirectQueue() {
        return QueueBuilder.durable(REDIRECT_QUEUE).build();
    }

    /**
     * 死信路由通过DL_KEY绑定键绑定到死信队列上
     */
    @Bean
    public Binding deadLetterBinding() {
        return new Binding(DL_QUEUE, Binding.DestinationType.QUEUE, DL_EXCHANGE, DL_KEY, null);

    }

    /**
    * 转发队列绑定到死信路由
    */
    @Bean
    public Binding redirectBinding() {
        return new Binding(REDIRECT_QUEUE, Binding.DestinationType.QUEUE, DL_EXCHANGE, DL_R_KEY, null);
    }
}
