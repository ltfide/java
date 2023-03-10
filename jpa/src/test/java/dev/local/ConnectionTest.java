package dev.local;

import org.h2.Driver;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    void testConnection() {
        EntityManagerFactory app = Persistence.createEntityManagerFactory("MyApp");
        EntityManager entityManager = app.createEntityManager();

        System.out.println("Connected");

        entityManager.close();
        app.close();
    }

    @Test
    void testManualConnectionH2() throws SQLException {
        String url = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "";

        Driver h2 = new org.h2.Driver();
        DriverManager.registerDriver(h2);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected");
    }

    @Test
    void testManualConnectionPostgreSQL() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/exercise";
        String user = "postgres";
        String password = "postgres";

        org.postgresql.Driver postgre = new org.postgresql.Driver();
        DriverManager.registerDriver(postgre);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected");
    }
}
