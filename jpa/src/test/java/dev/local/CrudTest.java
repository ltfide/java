package dev.local;

import dev.local.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrudTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Lutfi");
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        assertEquals("1", customer.getId());
        assertEquals("Lutfi", customer.getName());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void update() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        customer.setName("Lutfi Dendiansyah");
        entityManager.merge(customer);

        assertEquals("1", customer.getId());
        assertEquals("Lutfi Dendiansyah", customer.getName());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void remove() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
