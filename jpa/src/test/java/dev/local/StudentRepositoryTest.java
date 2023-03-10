package dev.local;

import dev.local.entities.Student;
import dev.local.repositories.StudentRepository;
import org.junit.jupiter.api.*;

public class StudentRepositoryTest {

    private static StudentRepository studentRepository;

    @BeforeAll
    static void beforeAll() {
        studentRepository = new StudentRepository();
    }

    @AfterAll
    static void afterAll() {
        studentRepository.close();
    }

    @Test
    void testAdd() {
        Student request = new Student();
        request.setFirstName("Lutfi");
        request.setLastName("Dendiansyah");

        Student student = studentRepository.add(request);

        Assertions.assertEquals("Lutfi", student.getFirstName());
        Assertions.assertEquals("Dendiansyah", student.getLastName());
    }

    @Test
    void testFind() {
        Long id = 3L;
        Student student = studentRepository.find(id);

        Assertions.assertEquals(3, student.getId());
        Assertions.assertEquals("Lutfi", student.getFirstName());
        Assertions.assertEquals("Dendiansyah", student.getLastName());
    }

    @Test
    void testUpdate() {
        Student request = new Student();
        request.setId(3L);
        request.setFirstName("Lutfi (updated)");
        request.setLastName("Dendiansyah (updated)");

        Student student = studentRepository.update(request);

        Assertions.assertEquals(3, student.getId());
        Assertions.assertEquals("Lutfi (updated)", student.getFirstName());
        Assertions.assertEquals("Dendiansyah (updated)", student.getLastName());
    }

    @Test
    void testDelete() {
        Long id = 3L;
        boolean deleted = studentRepository.delete(id);

        Assertions.assertTrue(deleted);
    }
}
