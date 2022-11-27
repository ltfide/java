package belajar.java.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String name = "lutfi';#";
        String email = "salah";

        String sql = "SELECT * FROM customers WHERE name = '" + name +
                "' AND email = '" + email + "'";
        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // Sukses login
            System.out.println("Sukses Login: " + resultSet.getString("name"));
        } else {
            // Gagal login
            System.out.println("Gagal Login");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
