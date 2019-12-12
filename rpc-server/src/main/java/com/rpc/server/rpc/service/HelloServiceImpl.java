package com.rpc.server.rpc.service;

import com.whis.domain.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String str) {
        return "hello " + str + "!";
    }
}
