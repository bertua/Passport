package br.com.flarom.passport.Objects;

import java.sql.*;
import java.util.ArrayList;

public class LoginAttempt {

    private int id_attempt;
    private int id_user;
    private Timestamp event;
    private boolean successful;

    public LoginAttempt() {
    }

    public LoginAttempt(int id_user, boolean success) {
        this.id_user = id_user;
        this.successful = success;
        this.event = new Timestamp(System.currentTimeMillis());
    }
    
    public LoginAttempt(int id_attempt, int id_user, Timestamp event, boolean successful) {
        this.id_attempt = id_attempt;
        this.id_user = id_user;
        this.event = event;
        this.successful = successful;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public int getId_attempt() {
        return id_attempt;
    }

    public void setId_attempt(int id_attempt) {
        this.id_attempt = id_attempt;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Timestamp getEvent() {
        return event;
    }

    public void setEvent(Timestamp event) {
        this.event = event;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
    //</editor-fold>

    public void Create() {
        String sql = "INSERT INTO login_attempts (id_user, event, successful) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            stmt.setTimestamp(2, event);
            stmt.setBoolean(3, successful);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // shearch for an exact login attempt
    public static LoginAttempt Read(int id_attempt) {
        String sql = "SELECT * FROM login_attempts WHERE id_attempt = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_attempt);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new LoginAttempt(
                        rs.getInt("id_attempt"),
                        rs.getInt("id_user"),
                        rs.getTimestamp("event"),
                        rs.getBoolean("successful")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // list all login attempts made by a user
    public static ArrayList<LoginAttempt> ListFromUser(int id_user) {
        ArrayList<LoginAttempt> attempts = new ArrayList<>();
        String sql = "SELECT * FROM login_attempts WHERE id_user = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                attempts.add(new LoginAttempt(
                        rs.getInt("id_attempt"),
                        rs.getInt("id_user"),
                        rs.getTimestamp("event"),
                        rs.getBoolean("successful")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attempts;
    }

    // list all login attempts made by a user in a day
    public static ArrayList<LoginAttempt> ListFromUserOnDate(int id_user, Timestamp date) {
        ArrayList<LoginAttempt> attempts = new ArrayList<>();
        String sql = "SELECT * FROM login_attempts WHERE id_user = ? AND DATE(event) = DATE(?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            stmt.setTimestamp(2, date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                attempts.add(new LoginAttempt(
                        rs.getInt("id_attempt"),
                        rs.getInt("id_user"),
                        rs.getTimestamp("event"),
                        rs.getBoolean("successful")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attempts;
    }

    // list all login attempts made by a user in a exact moment
    public static ArrayList<LoginAttempt> ListFromUserOnTimestamp(int id_user, Timestamp event) {
        ArrayList<LoginAttempt> attempts = new ArrayList<>();
        String sql = "SELECT * FROM login_attempts WHERE id_user = ? AND event = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            stmt.setTimestamp(2, event);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                attempts.add(new LoginAttempt(
                        rs.getInt("id_attempt"),
                        rs.getInt("id_user"),
                        rs.getTimestamp("event"),
                        rs.getBoolean("successful")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attempts;
    }

    // list ALL login attempts!! ALL OF THEM!!! FROM EVERYONE!!!!
    public static ArrayList<LoginAttempt> readAll() {
        ArrayList<LoginAttempt> attempts = new ArrayList<>();
        String sql = "SELECT * FROM login_attempts";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                attempts.add(new LoginAttempt(
                        rs.getInt("id_attempt"),
                        rs.getInt("id_user"),
                        rs.getTimestamp("event"),
                        rs.getBoolean("successful")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attempts;
    }
}
