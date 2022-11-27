package belajar.lambda.app;

import java.util.function.Predicate;

public class PredicateApp {
    public static void main(String[] args) {

        Predicate<String> predicateCheckBlank = value -> value.isBlank();
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer s) {
                return s > 6;
            }
        };
        Predicate<Integer> isOdd = t -> t % 2 == 1;

        System.out.println(predicateCheckBlank.test(""));
        System.out.println(isPositive.test(15));
        System.out.println(isOdd.test(5));

        if (isOdd.test(6)) {
            System.out.println("is odd number");
        } else {
            System.out.println("is not odd number");
        }

    }
}
