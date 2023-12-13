package com.haseeb.springbootwebfluxdemo.router;

import com.haseeb.springbootwebfluxdemo.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Autowired
    private CustomerHandler customerHandler;

    @Bean
    public RouterFunction<ServerResponse> customerRoutes() {
        return RouterFunctions.route()
                .GET("/router/customers/mono",customerHandler::getCustomerMono)
                .GET("/router/customers/stream",customerHandler::getCustomerStream)
                .build();
    }
}
