package belajar.collection;

import belajar.collection.data.Person;

import java.util.List;

public class MutableApp {
    public static void main(String[] args) {

        Person person = new Person("Lutfi");

        person.addHobby("Game");
        person.addHobby("Coding");

        doSomething(person.getHobbies());

        for (var hobby : person.getHobbies()) {
            System.out.println(hobby);
        }
    }

    public static void doSomething(List<String> hobbies) {
        hobbies.add("Not hobby");
    }
}
