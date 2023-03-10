package dev.local;

import dev.local.entities.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

public class JpqlTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("MyApp");
        em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setFirstName("Lutfi");
        student.setLastName("Dendiansyah");
        em.persist(student);

        transaction.commit();
    }

    @AfterAll
    static void afterAll() {
        em.close();
        emf.close();
    }

    @Test
    void testNamedQuery() {
        Query query = em.createNamedQuery("find student by id");
        query.setParameter("id", 1L);

        Student result = (Student) query.getSingleResult();
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Lutfi", result.getFirstName());
        Assertions.assertEquals("Dendiansyah", result.getLastName());
    }

    @Test
    void testFindFirstNameStartsWith() {
        String keyword = "L";
        
        Query query = em.createQuery("select s from Student s where s.firstName like :keyword");
        query.setParameter("keyword", keyword + "%");

        List<Student> students = query.getResultList();
        Assertions.assertEquals(1, students.size());
    }

    @Test
    void testFindFirstNameEndWith() {
        String keyword = "i";

        Query query = em.createQuery("select s from Student s where s.firstName like :keyword");
        query.setParameter("keyword", "%" + keyword);

        List<Student> students = query.getResultList();
        Assertions.assertEquals(1, students.size());
    }

    @Test
    void testTotal() {
        Query query = em.createQuery("select count(s) from Student s");
        Long total = (Long) query.getSingleResult();

        Assertions.assertEquals(1, total);
    }

    @Test
    void testUpdateFirstNameById() {
        String firstName = "Ltfi";
        Long id = 1L;

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("update Student s set s.firstName = :firstName where s.id = :id");
        query.setParameter("firstName", firstName);
        query.setParameter("id", id);

        int response = query.executeUpdate();
        transaction.commit();
        em.clear();

        Query query2 = em.createNamedQuery("find student by id");
        query2.setParameter("id", id);

        Student student = (Student) query2.getSingleResult();

        Assertions.assertEquals(1, response);
        Assertions.assertEquals(id, student.getId());
        Assertions.assertEquals(firstName, student.getFirstName());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("delete from Student s where s.id = :id");
        query.setParameter("id", id);

        int response = query.executeUpdate();
        transaction.commit();

        Assertions.assertEquals(1, response);
    }
}
