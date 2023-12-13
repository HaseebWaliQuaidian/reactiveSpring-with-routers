package com.haseeb.springbootwebfluxdemo.service;

import com.haseeb.springbootwebfluxdemo.dao.CustomerDao;
import com.haseeb.springbootwebfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("total execution time "+ (end -start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersAsync() {
        return customerDao.getCustomersAsync();
    }
}
