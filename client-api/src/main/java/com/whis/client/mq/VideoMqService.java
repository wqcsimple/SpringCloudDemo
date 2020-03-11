package com.whis.client.mq;

import com.whis.client.config.mq.DirectQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: carl
 * @Date: 2020-01-05 17:23
 */
@Slf4j
@Component
@RabbitListener(queues = {DirectQueueConfig.DIR_QUEUE})
public class VideoMqService {

    @RabbitHandler
    public void process(Map msg) {
        log.info("收到消息: {}", msg.toString());
    }
}
