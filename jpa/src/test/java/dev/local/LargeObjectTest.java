package dev.local;

import dev.local.entities.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeObjectTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BELAJAR");
    }

    @Test
    void insert() throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Image image = new Image();
        image.setName("Image 1");
        image.setDescription("Description image 1");

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("images/image.png");
        byte[] bytes = inputStream.readAllBytes();
        image.setImage(bytes);
        entityManager.persist(image);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
