package belajar.lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.addAll(List.of("Lutfi", "Dendiansyah"));

        // for loop
        // for (var name : names) {
        // if (name.length() > 5) {
        // names.remove(name);
        // }
        // }

        // remove if anonymous class
        // names.removeIf(new Predicate<String>() {
        // @Override
        // public boolean test(String value) {
        // return value.length() > 4;
        // }
        // });

        // lambda
        names.removeIf(name -> name.length() > 5);

        System.out.println(names);
    }
}
