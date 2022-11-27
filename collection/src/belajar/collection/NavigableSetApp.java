package belajar.collection;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
   public static void main(String[] args) {
      
      NavigableSet<String> names = new TreeSet<>();
      names.add("Satu");
      names.addAll(Set.of("Dua", "Tiga"));

      NavigableSet<String> namesReverse = names.descendingSet();
      NavigableSet<String> tiga = names.tailSet("Tiga", true);

      for (var name : namesReverse) {
         System.out.println(name);
      }

      NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(names);
      try {
         immutable.add("ERROR");
      } catch (UnsupportedOperationException e) {
         System.out.println("ERROR");
      }

   }
}
