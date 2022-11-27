package learn.javaoop.application;

import learn.javaoop.data.Animal;
import learn.javaoop.data.Cat;

public class AnimalApp {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.name = "Mpuss";
        animal.run();
    }
}
