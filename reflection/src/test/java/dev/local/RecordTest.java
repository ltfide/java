package dev.local;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dev.local.data.Product;

public class RecordTest {

    @Test
    void testClassRecord() {
        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord()); // true
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));

        // output
        // [private final java.lang.String dev.local.data.Product.id, private final
        // java.lang.String dev.local.data.Product.name, private final java.lang.Long
        // dev.local.data.Product.price]
        //
        // [public java.lang.String dev.local.data.Product.name(), public final boolean
        // dev.local.data.Product.equals(java.lang.Object), public final
        // java.lang.String dev.local.data.Product.toString(), public final int
        // dev.local.data.Product.hashCode(), public java.lang.String
        // dev.local.data.Product.id(), public java.lang.Long
        // dev.local.data.Product.price()]
        //
        // [public
        // dev.local.data.Product(java.lang.String,java.lang.String,java.lang.Long)]
        //
        // [java.lang.String id, java.lang.String name, java.lang.Long price]
    }

    @Test
    void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Product> productClass = Product.class;
        Method id = productClass.getDeclaredMethod("id");

        Product product = new Product("1", "Product 1", 200000L);
        System.out.println(id.invoke(product)); // 1
    }

    @Test
    void testGetRecordValueByComponent()
            throws InvocationTargetException, IllegalAccessException {
        Class<Product> productClass = Product.class;
        RecordComponent[] components = productClass.getRecordComponents();

        Product product = new Product("1", "Product 1", 200000L);

        for (RecordComponent component : components) {
            Method accessor = component.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
            System.out.println("========");
        }

        // output
        // id
        // 1
        // ========
        // name
        // Product 1
        // ========
        // price
        // 200000
        // ========
    }
}
