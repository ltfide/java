package dev.local;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.local.entities.Member;
import dev.local.entities.Name;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmbeddedTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void embedded() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        member.setEmail("lutfi@mail.com");

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Lutfi");
        name.setLastName("Dendiansyah");

        member.setName(name);
        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
