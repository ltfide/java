package dev.local;

import dev.local.entities.Credential;
import dev.local.entities.User;
import dev.local.entities.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneToOneTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void insertCategory() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Credential credential = new Credential();
        credential.setId("lutfi");
        credential.setEmail("lutfi@example.com");
        credential.setPassword("123");
        entityManager.persist(credential);

        User user = new User();
        user.setId("lutfi");
        user.setName("Lutfi");
        entityManager.persist(user);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "lutfi");
        Assertions.assertNotNull(user.getCredential());
        Assertions.assertEquals("lutfi@example.com", user.getCredential().getEmail());
        Assertions.assertEquals("123", user.getCredential().getPassword());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void insertWallet() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "lutfi");

        Wallet wallet = new Wallet();
        wallet.setBalance(1_000_000L);
        wallet.setUser(user);
        entityManager.persist(wallet);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void findWallet() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "lutfi");
        Assertions.assertNotNull(user.getWallet());
        Assertions.assertEquals(1_000_000L, user.getWallet().getBalance());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
