package com.whis.client.mq;

import com.whis.client.config.mq.DelayQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: carl
 * @Date: 2020-01-05 17:23
 */
@Slf4j
@Component
@RabbitListener(queues = {DelayQueueConfig.REDIRECT_QUEUE})
public class DelayMqService {

    @RabbitHandler
    public void process(String msg) {
        log.info("============= receive_message ============= {}", msg);
    }
}
