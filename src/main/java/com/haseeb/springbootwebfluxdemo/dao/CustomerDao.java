package com.haseeb.springbootwebfluxdemo.dao;

import com.haseeb.springbootwebfluxdemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void fakeDelay(int i){
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,10)
                .peek(CustomerDao::fakeDelay)
                .peek(i -> System.out.println("processing count "+i))
                .mapToObj(i -> new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersAsync(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count "+i))
                .map(i -> new Customer(i,"customer"+i));
    }
}
