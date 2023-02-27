package belajar.collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
   public static void main(String[] args) {

      Deque<String> deque = new LinkedList<>();

      deque.offerLast("Satu");
      deque.offerLast("Dua");
      deque.offerLast("Tiga");
      deque.offerLast("Empat");

      // for (String item = deque.pollLast(); item != null; item = deque.pollLast()) {
      // System.out.println(item);
      // }

      System.out.println(deque.pollLast()); // Empat
      System.out.println(deque.pollLast()); // Tiga
      System.out.println(deque.pollLast()); // Dua
      System.out.println(deque.pollLast()); // Satu

      Deque<String> queue = new LinkedList<>();

      queue.offerLast("Satu");
      queue.offerLast("Dua");
      queue.offerLast("Tiga");
      queue.offerLast("Empat");
      queue.offerLast("Lima");

      System.out.println(queue.pollFirst()); // Satu
      System.out.println(queue.pollFirst()); // Dua
      System.out.println(queue.pollFirst()); // Tiga
      System.out.println(queue.pollFirst()); // Empat
      System.out.println(queue.getFirst()); // Lima
      System.out.println(queue.size()); // 1

   }
}
