package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {

    @Test
    void testGroupingBy() {
        Map<String, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(number -> {
                    if (number % 2 == 0) {
                        return "Genap";
                    } else {
                        return "Ganjil";
                    }
                }));
        System.out.println(collect); // {Genap=[2, 4, 6], Ganjil=[1, 3, 5]}
    }

    @Test
    void testPartitioningBy() {
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .collect(Collectors.partitioningBy(number -> {
                    return number % 2 == 0;
                }));
        System.out.println(collect); // {false=[1, 3, 5, 7], true=[2, 4, 6, 8]}
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
        System.out.println(map); // {Panjang=[Dendiansyah], Pendek=[Lutfi]}
    }

    @Test
    void testPartitioningBy2() {
        Map<Boolean, List<String>> map = Stream.of("Lutfi", "Dendiansyah")
                .collect(Collectors.partitioningBy(name -> {
                    return name.length() > 5;
                }));
        System.out.println(map); // {false=[Lutfi], true=[Dendiansyah]}
    }

}
