package com.whis.two.controller;

import com.whis.two.feign.TestFeignService;
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
    private TestFeignService testFeignService;

    @RequestMapping("/test")
    public String home(@RequestParam(value = "name", defaultValue = "whis") String name) {
        return testFeignService.test(name);
    }
}
