package dev.local;

import dev.local.entities.Book;
import dev.local.entities.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyTest {

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
    void addBook() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = new Student();
        student.setFirstName("Lutfi");
        student.setLastName("Dendiansyah");
        em.persist(student);

        Book book = new Book();
        book.setName("Science");
        book.setPrice(10000D);
        book.getStudents().add(student);
        em.persist(book);

        transaction.commit();

        Book response = em.find(Book.class, 2L);
        System.out.println(response);
    }
}
