package com.huandv.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

/**
 * @Description:
 * @Project: microservice_spring-cloud
 * @Date: 7/4/2024 3:13 PM
 * @Author: crist
 */
@Configuration
public class ApiGatewayRouterConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/employee").uri("https://www.facebook.com/"))
                .route(p->p.path("/employee/**").uri("lb://EMPLOYEE-SERVICE"))
                .route(p->p.path("/department/**").uri("lb://department-SERVICE"))
                .route(p->p.path("/organization/**").uri("lb://organization-service"))
                .build();
    }
}
