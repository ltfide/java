package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.BlogPost;
import com.example.model.QBlogPost;
import com.example.model.QUser;
import com.example.model.User;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.JPAExpressions;
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

        BlogPost blogPost1 = new BlogPost();
        blogPost1.setTitle("Hello World!");
        blogPost1.setUser(user1);
        em.persist(blogPost1);

        BlogPost blogPost2 = new BlogPost();
        blogPost2.setTitle("My Second Post");
        blogPost2.setUser(user1);
        em.persist(blogPost2);

        BlogPost blogPost3 = new BlogPost();
        blogPost3.setTitle("Hello World!");
        blogPost3.setUser(user3);
        em.persist(blogPost3);

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

    @Test
    void whenGroupingByTitle_thenReturnsTuples() {

        QBlogPost qBlogPost = QBlogPost.blogPost;

        NumberPath<Long> count = Expressions.numberPath(Long.class, "c");

        List<Tuple> userTitleCounts = queryFactory.select(qBlogPost.title, qBlogPost.id.count().as(count))
                .from(qBlogPost).groupBy(qBlogPost.title).orderBy(count.desc())
                .fetch();

        System.out.println(userTitleCounts); // [[Hello World!, 2], [My Second Post, 1]]
        System.out.println(count); // c

        assertEquals("Hello World!", userTitleCounts.get(0).get(qBlogPost.title));
        assertEquals(2L, userTitleCounts.get(0).get(count));

        assertEquals("My Second Post", userTitleCounts.get(1).get(qBlogPost.title));
        assertEquals(1L, userTitleCounts.get(1).get(count));
    }

    @Test
    void whenJoiningWithCondition_theResultCountShouldMatch() {

        QUser qUser = QUser.user;
        QBlogPost qBlogPost = QBlogPost.blogPost;

        List<User> users = queryFactory.selectFrom(qUser)
                .innerJoin(qUser.blogPosts, qBlogPost)
                .on(qBlogPost.title.eq("Hello World!"))
                .fetch();

        assertEquals(2, users.size());
    }

    @Test
    void whenRefiningWithSubquery_thenResultCountShouldMatch() {

        QUser qUser = QUser.user;
        QBlogPost qBlogPost = QBlogPost.blogPost;

        List<User> users = queryFactory.selectFrom(qUser)
                .where(qUser.id.in(
                        JPAExpressions.select(qBlogPost.user.id)
                                .from(qBlogPost)
                                .where(qBlogPost.title.eq("Hello World!"))))
                .fetch();

        assertEquals(2, users.size());
    }
}
