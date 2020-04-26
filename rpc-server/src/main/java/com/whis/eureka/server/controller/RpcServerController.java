package com.whis.eureka.server.controller;

import com.whis.domain.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpcServerController {

    @RequestMapping("test")
    public String test(String name) {
        return "test";
    }
}
