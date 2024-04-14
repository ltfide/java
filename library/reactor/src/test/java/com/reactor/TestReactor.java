package com.reactor;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestReactor {
    
    @Test
    void createFlux() {
        List<String> l1 = Arrays.asList("one", "two", "three");
        Flux<String> flx1 = Flux.fromIterable(l1);
        flx1.subscribe(System.out::println);

        Flux<Integer> flx2 = Flux.just(1, 2, 3);
        flx2.subscribe(System.out::println);

        Flux<Integer> fromFiveToSeven = Flux.range(5, 3);
        fromFiveToSeven.subscribe(System.out::println);
    }

    @Test
    void createMono() {
        Mono<String> empty = Mono.empty();
        System.out.println(empty.block()); // null

        Mono.just("a")
            .flatMap(t -> Mono.just(t.toUpperCase()))
            .subscribe(System.out::println);  // A
    }

    @Test
    void testSubscribe() {
        Flux<Integer> flx1 = Flux.range(1, 4).map(n -> {
            if (n <= 3) return n;
            throw new RuntimeException("Got to 4");
        });

        flx1.subscribe(System.out::println, 
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("finished")); // we must take care not to trigger an error
    }
}
