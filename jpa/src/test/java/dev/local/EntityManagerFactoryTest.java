package dev.local;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class EntityManagerFactoryTest {

    @Test
    void createEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");

        entityManagerFactory.close();
    }
}
