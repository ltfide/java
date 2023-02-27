package belajar.collection;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import belajar.collection.data.Person;
import belajar.collection.data.PersonComparator;

public class SortedSetApp {
   public static void main(String[] args) {

      SortedSet<Person> people = new TreeSet<>(new PersonComparator());

      people.add(new Person("Lutfi"));
      people.add(new Person("Dendiansyah"));

      for (var person : people) {
         System.out.println(person.getName());
      }

      SortedSet<Person> sortedSet = Collections.unmodifiableSortedSet(people);
      // sortedSet.add(new Person("Lutfi")); // ERROR

   }
}
