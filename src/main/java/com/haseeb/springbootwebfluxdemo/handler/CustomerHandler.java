package com.haseeb.springbootwebfluxdemo.handler;

import com.haseeb.springbootwebfluxdemo.dao.CustomerDao;
import com.haseeb.springbootwebfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> getCustomerStream(ServerRequest request) {
        Flux<Customer> customers = customerDao.getCustomersAsync();
        return ServerResponse.ok().body(customers,Customer.class);
    }

    public Mono<ServerResponse> getCustomerMono(ServerRequest request) {
        Flux<Customer> customers = customerDao.getCustomersAsync();
        return ServerResponse.ok().body(customers,Customer.class);
    }
}
