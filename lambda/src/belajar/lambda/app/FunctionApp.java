package belajar.lambda.app;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {

        Function<String, String> functionTrim = value -> value.trim();
        Function<String, Integer> funcLength = String::length;

        System.out.println(functionTrim.apply("Lutfi      "));
        System.out.println(funcLength.apply("Lutfi"));

    }
}
