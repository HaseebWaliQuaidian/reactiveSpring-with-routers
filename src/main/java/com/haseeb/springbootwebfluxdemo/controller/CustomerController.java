package com.haseeb.springbootwebfluxdemo.controller;

import com.haseeb.springbootwebfluxdemo.dto.Customer;
import com.haseeb.springbootwebfluxdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/sync-approach")
    public List<Customer> getCustomers(){
        return customerService.loadAllCustomers();
    }

    @GetMapping("/async-approach")
    public Flux<Customer> getCustomersAsync(){
        return customerService.loadAllCustomersAsync();
    }
}
