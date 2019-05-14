package com.whis.client.controller;

import com.whis.client.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whis on 2019-05-14
 */
@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String home(@RequestParam(value = "name", defaultValue = "whis") String name) {
//        return "hi " + name + " , i am from port:" + port;
        return testService.sayHello(name);
    }
}
