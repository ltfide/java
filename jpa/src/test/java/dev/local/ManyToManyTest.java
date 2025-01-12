package dev.local;

import dev.local.entities.Product;
import dev.local.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManyToManyTest {

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

        User user = entityManager.find(User.class, "lutfi");
        user.setLikes(new HashSet<>());
        user.getLikes().add(entityManager.find(Product.class, "1"));
        user.getLikes().add(entityManager.find(Product.class, "2"));
        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void select() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "lutfi");
        assertEquals(2, user.getLikes().size());

        Product product = entityManager.find(Product.class, "1");
        assertEquals(1, product.getLikedBy().size());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
