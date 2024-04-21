package com.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class SchedulerTest {

    @Test
    void test() throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        Flux<String> flux = Flux.range(1, 100000)
                .publishOn(s)
                .map(n -> n + " Thread: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> flux.subscribe(System.out::println));
        thread1.start();
        thread1.join();

        Thread.sleep(5_000L);
    }
}
