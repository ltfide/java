package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

        User user2 = new User();
        user2.setName("Dh");
        user2.setEmail("dh@mail.com");
        em.persist(user2);

        User user3 = new User();
        user3.setName("Zh");
        user3.setEmail("zh@mail.com");
        em.persist(user3);

        em.getTransaction().commit();

        em.close();
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    void whenFindByUsername_thenShouldReturnUser() {

        QUser quser = QUser.user;
        User user = queryFactory.selectFrom(quser)
                .where(quser.name.eq("Lutfi"))
                .fetchOne();

        assertEquals("Lutfi", user.getName());
        assertEquals("lutfi@mail.com", user.getEmail());
    }

    @Test
    void whenUsingOrderBy_theResultsShouldOrdered() {

        QUser qUser = QUser.user;
        List<User> users = queryFactory.selectFrom(qUser)
                .orderBy(qUser.name.asc())
                .fetch();

        assertEquals(3, users.size());
        assertEquals("Dh", users.get(0).getName());
        assertEquals("Lutfi", users.get(1).getName());
        assertEquals("Zh", users.get(2).getName());
    }
}
