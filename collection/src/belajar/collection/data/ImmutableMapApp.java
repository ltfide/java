package belajar.collection.data;

import java.util.Map;

public class ImmutableMapApp {
    public static void main(String[] args) {

        Map<String, String> map = Map.of(
                "first", "Lutfi",
                "last", "Dendiansyah"
        );

        System.out.println(map);
        // map.put("error", "ERROR"); // ERROR

    }
}
