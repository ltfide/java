package dev.local;

import dev.local.entities.Customer;
import dev.local.entities.CustomerType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnumTest {

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
        customer.setId("3");
        customer.setName("Jack");
        customer.setPrimaryEmail("jack@mail.com");
        customer.setMarried(false);
        customer.setAge((byte) 30);
        customer.setType(CustomerType.VIP);
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
