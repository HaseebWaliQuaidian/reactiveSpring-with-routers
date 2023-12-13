package com.haseeb.springbootwebfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void monoTest(){
        Mono<String> stringMono = Mono.just("haseeb testing mono").log();
        stringMono.subscribe(System.out::println);
    }

    @Test
    public void fluxTest(){
        Flux<String> stringFlux = Flux.just("String", "Spring Boot", "haseeb", "testing")
                .concatWithValues("testing concat value")
                .log();

        stringFlux.subscribe(System.out::println);
    }

    @Test
    public void fluxAfterErrorNextValueIsNotPublished(){
        Flux<String> stringFlux = Flux.just("String", "Spring Boot", "haseeb", "testing")
                .concatWithValues("testing concat value")
                .concatWith(Flux.error(new RuntimeException("this is a custom exception")))
                .concatWithValues("This value should not be returned")
                .log();

        stringFlux.subscribe(
                System.out::println,
                e -> System.out.println(e.getMessage())
        );
    }
}
