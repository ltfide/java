package dev.local;

import dev.local.entities.isa.Employee;
import dev.local.entities.isa.Manager;
import dev.local.entities.isa.VicePresident;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsATest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = new Employee();
        employee.setId("aA");
        employee.setName("AA");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("bB");
        manager.setName("BB");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePresident vp = new VicePresident();
        vp.setId("cC");
        vp.setName("CC");
        vp.setTotalManager(20);
        entityManager.persist(vp);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void select() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = entityManager.find(Employee.class, "cC");
        VicePresident vp = (VicePresident) employee;

        Assertions.assertEquals(20, vp.getTotalManager());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
