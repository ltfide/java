package belajar.lambda;

import belajar.lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {
    public static void main(String[] args) {

        // Predicate<String> predicate = value -> StringUtil.isLowerCase(value);
        Predicate<String> predicate = StringUtil::isLowerCase;

        System.out.println(predicate.test("Lutfi"));
        System.out.println(predicate.test("dendiansyah"));

        // Method reference di parameter
        // Function<String, String> functionUpper = (String value) -> value.toUpperCase();
        Function<String, String> functionUpper = String::toUpperCase;

        System.out.println(functionUpper.apply("Lutfi"));

    }

    public void run() {
        Predicate<String> predicateIsLowerCase = this::isLowerCase;

        System.out.println(predicateIsLowerCase.test("lutfi"));
        System.out.println(predicateIsLowerCase.test("Lutfi"));
    }
    public void run2() {
        MethodReferenceApp app = new MethodReferenceApp();
        Predicate<String> predicateIsLowerCase = app::isLowerCase;

        System.out.println(predicateIsLowerCase.test("lutfi"));
        System.out.println(predicateIsLowerCase.test("Lutfi"));
    }

    public boolean isLowerCase(String value) {
        for (var c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
