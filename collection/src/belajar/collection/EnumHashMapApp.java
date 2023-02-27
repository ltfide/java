package belajar.collection;

import java.util.EnumMap;
import java.util.Map;

public class EnumHashMapApp {
   public static enum Level {
      FREE, PREMIUM, VIP
   }

   public static void main(String[] args) {

      Map<Level, String> map = new EnumMap<>(Level.class);

      map.put(Level.FREE, "gratis");
      map.put(Level.PREMIUM, "bayar");

      System.out.println(map.get(Level.FREE)); // gratis
      System.out.println(map.get(Level.PREMIUM)); // bayar
      System.out.println(map.get(Level.VIP)); // null

      for (var key : map.keySet()) {
         System.out.println(key); // FREE // PREMIUM
      }

   }
}
