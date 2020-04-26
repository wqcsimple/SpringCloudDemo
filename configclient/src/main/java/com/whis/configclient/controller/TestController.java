package com.whis.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ClientController
 * @description:
 * @author: whis
 * @create: 2020-03-14 11:24
 **/
@RestController
public class TestController {

    @Value("${redis.type}")
    private String word;

    @RequestMapping("/hello")
    public String index() {
        return this.word;
    }
}
