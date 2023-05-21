package dev.local;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    void transaction() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Assertions.assertNotNull(entityTransaction);

        try {
            entityTransaction.begin();

            entityTransaction.commit();
        } catch (Throwable throwable) {
            entityTransaction.rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
