package belajar.lambda.app;

import java.util.function.Consumer;

public class ConsumerApp {
    public static void main(String[] args) {

        Consumer<String> consumer = value -> System.out.println(value);
        Consumer<String> consumer2 = System.out::println;
        Consumer<String> consumer3 = value -> System.out.println(value.toUpperCase());

        consumer.accept("Lutfi Dendiansyah");
        consumer2.accept("Consumer 2");
        consumer3.accept("Consumer 3");
        System.out.println(consumer.getClass());

    }
}
