package com.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.util.concurrent.atomic.AtomicLong;

class SampleSubsriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(10);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value);

        if (value instanceof String) return;

        int val = (int) value;
        if (val <= 9) request(5);
        if (val == 54) cancel();
        if (val == 55) {
            // not executed if cancel
            throw new RuntimeException("val is equals 55");
        }
    }

    @Override
    protected void hookOnCancel() {
        System.out.println("Cancel");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("error " + throwable.getMessage());
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Stream completed");
    }

    @Override
    protected void hookFinally(SignalType type) {
        System.out.println("FINALLY");
    }
}

public class BaseSubscriberTest {

    @Test
    void testSampleSubscriber() {
        SampleSubsriber<Integer> s1 = new SampleSubsriber<>();
        Flux<Integer> flux = Flux.range(1, 100);
        flux.subscribe(s1);
    }

    @Test
    void reshape() {
        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("Request: " + r))
                .subscribe(new SampleSubsriber<>());
    }

    @Test
    void generate() {
        Flux.generate(
            AtomicLong::new,
            (state, sink) -> {
                long i = state.incrementAndGet();
                sink.next(String.format("3 * %d = %d", i, 3 * i));
                if (i == 10) sink.complete();
                return state;
            }, (state) -> System.out.println("State: " + state)
        ).subscribe(new SampleSubsriber<>());
    }
}
