package com.rpc.client.controller;

import com.rpc.client.rpc.RpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpcClientController {


    @Autowired
    private RpcClient rpcClient;

    @RequestMapping("test")
    public String test(String name) {
        return rpcClient.sayHello(name);
    }
}
