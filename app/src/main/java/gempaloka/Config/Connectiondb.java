package gempaloka.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gempaloka";
    private static final String USER = "root";
    private static final String PASS = ""; // ganti jika ada password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}

