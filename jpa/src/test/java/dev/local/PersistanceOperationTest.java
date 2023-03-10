package dev.local;

import dev.local.entities.Student;
import org.junit.jupiter.api.*;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistanceOperationTest {

    private static EntityManager em;
    private static EntityManagerFactory entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManager = Persistence.createEntityManagerFactory("MyApp");
        em = entityManager.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        em.close();
        entityManager.close();
    }

    @Test
    void insertDataWithNativeQuery() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tbl_students(id, first_name, last_name) ");
        sb.append("VALUES (?, ?, ?)");

        Query query = em.createNativeQuery(sb.toString());
        query.setParameter(1, 1L);
        query.setParameter(2, "Lutfi");
        query.setParameter(3, "Dendiansyah");

        int result = query.executeUpdate();

        transaction.commit();
        Assertions.assertEquals(1, result);
    }

    @Test
    void insertDataWithPersist() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setFirstName("Lutfi");
        student.setLastName("Dendiansyah");

        em.persist(student);
        transaction.commit();
    }

    @Test
    void testFindData() {
        Student student = em.find(Student.class, 1L);

        Assertions.assertEquals(1, student.getId());
        Assertions.assertEquals("Lutfi", student.getFirstName());
        Assertions.assertEquals("Dendiansyah", student.getLastName());
    }

    @Test
    void testUpdateData() {
        EntityTransaction transaction = em.getTransaction();

        Student student = em.find(Student.class, 1L);

        transaction.begin();

        student.setFirstName("Lutfi (updated)");
        student.setLastName("Dendiansyah (updated)");

        transaction.commit();

        Assertions.assertEquals("Lutfi (updated)", student.getFirstName());
        Assertions.assertEquals("Dendiansyah (updated)", student.getLastName());
    }

    @Test
    void testDeleteData() {
        EntityTransaction transaction = em.getTransaction();

        Student student = em.find(Student.class, 1L);

        transaction.begin();

        em.remove(student);

        transaction.commit();

        Student deleted = em.find(Student.class, 1L);
        Assertions.assertNull(deleted);
    }
}
