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
      //    System.out.println(item);
      // }

      System.out.println(deque.pollLast());
      System.out.println(deque.pollLast());
      System.out.println(deque.pollLast());
      System.out.println(deque.pollLast());

      Deque<String> queue = new LinkedList<>();

      queue.offerLast("Satu");
      queue.offerLast("Dua");
      queue.offerLast("Tiga");
      queue.offerLast("Empat");
      queue.offerLast("Lima");

      System.out.println(queue.pollFirst());
      System.out.println(queue.pollFirst());
      System.out.println(queue.pollFirst());
      System.out.println(queue.pollFirst());
      System.out.println(queue.getFirst());
      System.out.println(queue.size());

   }
}
