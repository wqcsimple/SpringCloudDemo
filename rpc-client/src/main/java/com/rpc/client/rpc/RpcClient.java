package com.rpc.client.rpc;

import com.alipay.sofa.rpc.common.RpcConstants;
import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.whis.domain.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RpcClient {

    private HelloService helloService;

    @PostConstruct
    public void initRpcClient() {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:8803"); // 指定直连地址

        // 生成代理类
        helloService = consumerConfig.refer();
    }

    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
