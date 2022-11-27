package belajar.lambda.app;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LazyApp {
    public static void main(String[] args) {
        testScore(60, () -> getName());
        LazyApp testaja = new LazyApp();
        System.out.println(testaja.isLowerCase());
    }

    public static void testScore(int score, Supplier<String> name) {
        if (score > 80) {
            System.out.println("Selamat " + name.get() + " Anda lulus");
        } else {
            System.out.println("Coba lagi tahun depan");
        }
    }

    public static String getName() {
        System.out.println("Method getName() di panggil");
        return "Lutfi";
    }

    public boolean isLowerCase() {
        return true;
    }
}
