package dev.local;

import dev.local.entities.Member;
import dev.local.entities.Name;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void collectionTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTitle("Mrs");
        name.setFirstName("Lisa");
        name.setLastName("Aja");

        Member member = new Member();
        member.setEmail("lisa@mail.com");
        member.setName(name);
        member.setHobbies(List.of("Game", "Coding"));
        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void mapCollection() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Name name = new Name();
        name.setTitle("Mrs");
        name.setFirstName("Jack");
        name.setLastName("Aja");

        Member member = new Member();
        member.setEmail("jack@mail.com");
        member.setName(name);
        member.setHobbies(List.of("Cooking", "Reading"));
        member.setSkills(Map.of("Java", 100, "Golang", 90));
        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void collectionUpdate() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 3);
        member.setSkills(new HashMap<>());
        member.getSkills().put("Java", 100);
        entityManager.merge(member);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
