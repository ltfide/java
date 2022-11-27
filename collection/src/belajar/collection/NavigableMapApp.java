package belajar.collection;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
   public static void main(String[] args) {
      
      NavigableMap<String, String> map = new TreeMap<>();

      map.put("satu", "satu");
      map.put("dua", "dua");
      map.put("tiga", "tiga");
      map.put("empat", "empat");

      for (var key : map.keySet()) {
         System.out.println(key);
      }

      System.out.println(map.lowerKey("empat"));
      System.out.println(map.higherKey("empat"));

      NavigableMap<String, String> mapDesc = map.descendingMap();
      for (var key : mapDesc.keySet()) {
         System.out.println(key);
      }

      NavigableMap<String, String> empty = Collections.emptyNavigableMap();
      NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(mapDesc);

      System.out.println(empty);
      System.out.println(immutable);
      // immutable.put("error", "error"); // ERROR

   }
}
