package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineTest {

    @Test
    void testCreateStreamPipeline() {
        // jarang di gunakan cara seperti ini
        List<String> list = List.of("Lutfi", "Dendiansyah");

        Stream<String> stream = list.stream();
        Stream<String> streamUpper = stream.map(String::toUpperCase);
        Stream<String> streamMr = streamUpper.map(upper -> "Mr." + upper);

        streamMr.forEach(System.out::println);
    }

    @Test
    void testCreateStreamPipelineok() {
        List<String> list = List.of("Lutfi", "Dendiansyah");

        list.stream()
                .map(name -> name.toUpperCase())
                .map(upper -> "Mr." + upper)
                .forEach(System.out::println);
    }

}
