package dev.local;

import dev.local.entities.School;
import dev.local.entities.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOneTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyApp");
        em = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        em.close();
        entityManagerFactory.close();
    }

    @Test
    void addSchool() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        School school = new School();
        school.setName("School 1");
        school.setCity("City 1");
        em.persist(school);

        transaction.commit();

        School response = em.find(School.class, 1L);
        Assertions.assertEquals(1, response.getId());
        Assertions.assertEquals("School 1", response.getName());
        Assertions.assertEquals("City 1", response.getCity());
    }

    @Test
    void addStudent() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        School school = new School();
        school.setName("School 1");
        school.setCity("City 1");
        em.persist(school);

        Student student = new Student();
        student.setFirstName("Lutfi");
        student.setLastName("Dendiansyah");
        student.setSchool(school);
        em.persist(student);

        transaction.commit();

        Student response = em.find(Student.class, 2L);
        Assertions.assertEquals(2, response.getId());
        Assertions.assertEquals("Lutfi", response.getFirstName());
        Assertions.assertEquals("Dendiansyah", response.getLastName());
        Assertions.assertEquals("School 1", response.getSchool().getName());
        Assertions.assertEquals("City 1", response.getSchool().getCity());
    }
}
