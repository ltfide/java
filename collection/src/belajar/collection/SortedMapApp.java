package belajar.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
   public static void main(String[] args) {
      
      Comparator<String> stringComparator = new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
            return o2.compareTo(o1);
         }
      };

      SortedMap<String, String> sortedMap = new TreeMap<>(stringComparator);

      sortedMap.put("Lutfi", "Lutfi");
      sortedMap.put("Dendiansyah", "Dendiansyah");

      for (var key : sortedMap.keySet()) {
         System.out.println(key);
      }
      
      SortedMap<String, String> empty = Collections.emptySortedMap();
      SortedMap<String, String> immutable = Collections.unmodifiableSortedMap(sortedMap);

      try {
         immutable.put("Error", "Error");
      } catch (UnsupportedOperationException exception) {
         System.out.println("ERROR");
      }

   }
}
