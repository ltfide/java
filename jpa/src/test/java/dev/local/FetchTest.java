package dev.local;

import dev.local.entities.Brand;
import dev.local.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FetchTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void fetchLazy() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = entityManager.find(Product.class, "1");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void fetchLazyRelation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = entityManager.find(Product.class, "1");
        Brand brand = product.getBrand();
        Assertions.assertEquals("Honda", brand.getName());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
