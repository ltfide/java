package dev.local.repositories;

import dev.local.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentRepository {

    private EntityManager em;
    private EntityManagerFactory managerFactory;

    public StudentRepository() {
        this.managerFactory = Persistence.createEntityManagerFactory("MyApp");
        this.em = this.managerFactory.createEntityManager();
    }

    public Student add(Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(student);

        transaction.commit();
        return student;
    }

    public Student find(Long id) {
        Student student = em.find(Student.class, id);

        if (student == null) {
            return null;
        }
        return student;
    }

    public Student update(Student request) {
        Student student = em.find(Student.class, request.getId());

        if (student == null) {
            return null;
        }

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());

        transaction.commit();
        return student;
    }

    public boolean delete(Long id) {
        Student student = em.find(Student.class, id);

        if (student == null) {
            return false;
        }

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(student);

        transaction.commit();
        return true;
    }

    public void close() {
        em.close();
        managerFactory.close();
    }
}
