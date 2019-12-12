package com.rpc.server.rpc;

import com.alipay.sofa.rpc.common.RpcConstants;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.rpc.server.rpc.service.HelloServiceImpl;
import com.whis.domain.service.HelloService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RpcServer {

    @PostConstruct
    public void initServer() {
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol(RpcConstants.PROTOCOL_TYPE_BOLT)
                .setPort(8803) // 设置一个端口，默认12200
                .setDaemon(false); // 非守护线程

        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setRef(new HelloServiceImpl()) // 指定实现
                .setServer(serverConfig); // 指定服务端

        providerConfig.export(); // 发布服务

        System.out.println("服务发布成功");
    }
}
