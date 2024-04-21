package com.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

interface MyEventListener<T> {
    void onDataChunk(List<T> chunk);
    void processComplete();
}

class SampleListener implements MyEventListener<String> {

    private final FluxSink<Object> sink;

    SampleListener(FluxSink<Object> sink) {
        this.sink = sink;
    }

    @Override
    public void onDataChunk(List<String> chunk) {
        for (String chun : chunk) {
            sink.next(chun);
        }
    }

    @Override
    public void processComplete() {
        sink.complete();
    }
}

class MyEventProcessor {
    private MyEventListener<String> listener;

    public void register(MyEventListener<String> listener) {
        this.listener = listener;
    }

    public void processData(List<String> data) {
        listener.onDataChunk(data);
    }

    public void completeProcessing() {
        listener.processComplete();
    }
}

public class ListenerTest {

    @Test
    void create() throws InterruptedException {
        MyEventProcessor myEventProcessor = new MyEventProcessor();
        Flux<Object> flux = Flux.create(sink -> {
            myEventProcessor.register(new SampleListener(sink));
        });

        flux.subscribe(System.out::println,
            (err) -> System.out.println("Error: " + err),
            () -> System.out.println("Stream completed")
        );

        myEventProcessor.processData(Arrays.asList("Data1", "Data2", "Data3"));
        myEventProcessor.completeProcessing();
    }
}
