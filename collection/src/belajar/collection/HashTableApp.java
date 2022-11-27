package belajar.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {

        Map<String, String> map = new Hashtable();

        map.put("first", "Lutfi");
        map.put("last", "Dendiansyah");

        for (var value : map.values()) {
            System.out.println(value);
        }

    }
}
