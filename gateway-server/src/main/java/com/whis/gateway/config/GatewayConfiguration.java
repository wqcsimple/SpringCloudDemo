package com.whis.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GatewayConfiguration
 * @description:
 * @author: whis
 * @create: 2020-04-26 10:10
 **/
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_product", r -> r.path("/product/**")
                        .uri("http://localhost:8101/product/**")
                )
                .route("path_404", r -> r.path("/hello")
                        .uri("http://whis.wang"))
                .build();
    }

}
