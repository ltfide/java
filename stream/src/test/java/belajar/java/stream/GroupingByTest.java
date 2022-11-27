package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {

    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> collect = Stream.of(1,2,3,4,5,6)
                .collect(Collectors.groupingBy(number -> {
                    if (number % 2 == 0) {
                        return "Genap";
                    } else {
                        return "Ganjil";
                    }
                }));
        System.out.println(collect);
    }

    @Test
    void testPartitioningBy() {
        Map<Boolean, List<Integer>> collect = Stream.of(1,2,3,4,5,6,7,8)
                .collect(Collectors.partitioningBy(number -> {
                    return number % 2 == 0;
                }));
        System.out.println(collect);
    }

    @Test
    void testGropingBy2() {
        Map<String, List<String>> map = Stream.of("Lutfi", "Dendiansyah")
                .collect(Collectors.groupingBy(name -> {
                    if (name.length() > 5) {
                        return "Panjang";
                    } else {
                        return "Pendek";
                    }
                }));
        System.out.println(map);
    }

    @Test
    void testPartitioningBy2() {
        Map<Boolean, List<String>> map = Stream.of("Lutfi", "Dendiansyah")
                .collect(Collectors.partitioningBy(name -> {
                    return name.length() > 5;
                }));
        System.out.println(map);
    }

}
