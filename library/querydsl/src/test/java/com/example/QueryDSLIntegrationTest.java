package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.model.QUser;
import com.example.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QueryDSLIntegrationTest {

    private static EntityManagerFactory emf;

    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @BeforeAll
    public static void populateDatabase() {
        emf = Persistence.createEntityManagerFactory("com.example");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user1 = new User();
        user1.setName("Lutfi");
        user1.setEmail("lutfi@mail.com");
        em.persist(user1);

        em.getTransaction().commit();

        em.close();
    }

    @Test
    void whenFindByUsername_thenShouldReturnUser() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        queryFactory = new JPAQueryFactory(em);

        QUser quser = QUser.user;
        User user = queryFactory.selectFrom(quser)
                .where(quser.name.eq("Lutfi"))
                .fetchOne();

        assertEquals("Lutfi", user.getName());
        assertEquals("lutfi@mail.com", user.getEmail());
    }
}
