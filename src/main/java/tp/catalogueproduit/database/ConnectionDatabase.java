package tp.catalogueproduit.database;

import java.sql.*;

public class ConnectionDatabase {
    // Create connection to database
    private static final String url = "jdbc:mysql://localhost:3306/catalogueproduit";
    private static final String username = "root";
    private static final String password = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
