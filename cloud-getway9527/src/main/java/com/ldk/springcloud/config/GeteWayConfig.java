package com.ldk.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @class: GeteWayConfig
 * @author:
 * @date: 2020/12/10 14:38
 * @description:
 */
@Configuration
public class GeteWayConfig {
    @Bean
    public RouteLocator customrouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_ldk",
                r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
