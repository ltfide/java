package dev.local;

import dev.local.entities.Brand;
import dev.local.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneToManyTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("1");
        brand.setName("Honda");
        brand.setDescription("Honda Motor");
        entityManager.persist(brand);

        Product product1 = new Product();
        product1.setId("1");
        product1.setName("Honda CRF");
        product1.setPrice(30_000_000L);
        product1.setBrand(brand);
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setId("2");
        product2.setName("Honda CBR");
        product2.setPrice(50_000_000L);
        product2.setBrand(brand);
        entityManager.persist(product2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void selectBrand() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "1");
        System.out.println(brand.getId());
        System.out.println(brand.getName());
        System.out.println(brand.getDescription());

        for (Product product : brand.getProducts()) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void selectProduct() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = entityManager.find(Product.class, "1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getBrand().getId());
        System.out.println(product.getBrand().getName());
        System.out.println(product.getBrand().getDescription());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
