package com.whis.client.controller;

import com.whis.client.base.BaseRestVO;
import com.whis.client.config.mq.DelayQueueConfig;
import com.whis.client.config.mq.DirectQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestController
 * @description:
 * @author: whis
 * @create: 2020-03-11 17:14
 **/
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/rabbit-send")
    public BaseRestVO<Object> rabbitSend() {
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties mp = message.getMessageProperties();
            mp.setContentEncoding("utf-8");
            mp.setExpiration("10000");
            return message;
        };

        String msg = "hello world";

        log.info("========== send message ===========");

        rabbitTemplate.convertAndSend(DelayQueueConfig.DL_EXCHANGE, DelayQueueConfig.DL_KEY, msg, messagePostProcessor);
        return BaseRestVO.success(null);
    }

    @GetMapping("/video-mq-send")
    public BaseRestVO<Object> sendVideoMq() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "carl");
        map.put("age", "12");

        log.info("========== send message ===========");
        rabbitTemplate.convertAndSend(DirectQueueConfig.DIR_QUEUE, map);
        return BaseRestVO.success(null);
    }
}
