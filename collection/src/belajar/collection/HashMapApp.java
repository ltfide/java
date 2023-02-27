package belajar.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
   public static void main(String[] args) {
      Map<String, String> map = new HashMap<>();

      map.put("name.first", "Lutfi");
      map.put("name.last", "Dendiansyah");

      System.out.println(map.get("name.first")); // Lutfi
      System.out.println(map.get("name.last")); // Dendiansyah
      System.out.println(map.size()); // 2
      System.out.println(map.keySet()); // [name.first, name.last]
      System.out.println(map.hashCode()); // 1790306008
      System.out.println(map); // {name.first=Lutfi, name.last=Dendiansyah}
   }
}
