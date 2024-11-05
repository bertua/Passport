package br.com.flarom.passport.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private Connection connection;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:sqlite:passportdata.db",
                "", ""
            );
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
