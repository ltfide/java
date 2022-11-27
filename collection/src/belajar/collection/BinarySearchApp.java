package belajar.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {
    public static void main(String[] args) {

        List<Integer> search = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            search.add(i);
        }

        int binarySearchIndex = Collections.binarySearch(search, 256);
        System.out.println(binarySearchIndex);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int binarySearchIndex2 = Collections.binarySearch(search, 256);
        System.out.println(binarySearchIndex2);

    }
}
