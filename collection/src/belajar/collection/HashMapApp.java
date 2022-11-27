package belajar.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
   public static void main(String[] args) {
      
      Map<String, String> map = new HashMap<>();

      map.put("name.first", "Lutfi");
      map.put("name.last", "Dendiansyah");

      System.out.println(map.get("name.first"));
      System.out.println(map.get("name.last"));
      System.out.println(map.size());
      System.out.println(map.keySet());
      System.out.println(map.hashCode());
      System.out.println(map);

   }
}
