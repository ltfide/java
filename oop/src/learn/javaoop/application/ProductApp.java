package learn.javaoop.application;

import learn.javaoop.data.Product;

public class ProductApp {
    public static void main(String[] args) {
        Product product = new Product();
        product.name = "Indomie";
        product.price = 3000;

        System.out.println(product.getName());
        System.out.println(product.getPrice());
    }
}
