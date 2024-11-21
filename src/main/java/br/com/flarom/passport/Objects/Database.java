package br.com.flarom.passport.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:sqlite:passportdata.db",
                "", ""
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
