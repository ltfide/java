package belajar.generic.application;

import belajar.generic.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people = {
            new Person("Lutfi", "Indonesia"),
            new Person("Lisa", "Indonesia")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }
}
