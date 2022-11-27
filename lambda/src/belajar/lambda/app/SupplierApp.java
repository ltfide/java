package belajar.lambda.app;

import java.util.function.Supplier;

public class SupplierApp {
    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Lutfi Dendiansyah";
        Supplier<Integer> supplier2 = () -> 12;

        System.out.println(supplier.get());
        System.out.println(supplier2.get());
    }
}
