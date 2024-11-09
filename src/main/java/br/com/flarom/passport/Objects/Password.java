package br.com.flarom.passport.Objects;

import br.com.flarom.passport.Helpers.MiscHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Password {

    private int id_password;
    private int id_user;
    private int id_category;
    private String service_name;
    private String user_name;
    private String password;
    private Timestamp create_date;
    private Timestamp edit_date;
    private Timestamp view_date;
    private String color;

    public Password() {
    }

    public Password(int id_user, int id_category, String service_name, String user_name, String password, Timestamp create_date, Timestamp edit_date, Timestamp view_date, String color) {
        this.id_user = id_user;
        this.id_category = id_category;
        this.service_name = service_name;
        this.user_name = user_name;
        this.password = password;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.view_date = view_date;
        this.color = color;
    }
    
    public Password(int id_password, int id_user, int id_category, String service_name, String user_name, String password, Timestamp create_date, Timestamp edit_date, Timestamp view_date, String color) {
        this.id_password = id_password;
        this.id_user = id_user;
        this.id_category = id_category;
        this.service_name = service_name;
        this.user_name = user_name;
        this.password = password;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.view_date = view_date;
        this.color = color;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getId_password() {
        return id_password;
    }

    public void setId_password(int id_password) {
        this.id_password = id_password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(Timestamp edit_date) {
        this.edit_date = edit_date;
    }

    public Timestamp getView_date() {
        return view_date;
    }

    public void setView_date(Timestamp view_date) {
        this.view_date = view_date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //</editor-fold>

    public void Create() throws Exception {
        String sql = "INSERT INTO passwords (id_user, id_category, service_name, user_name, password, create_date, edit_date, view_date, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            stmt.setInt(2, id_category);
            stmt.setString(3, service_name);
            stmt.setString(4, user_name);
            stmt.setString(5, MiscHelper.encryptPassword(password));
            stmt.setTimestamp(6, create_date);
            stmt.setTimestamp(7, edit_date);
            stmt.setTimestamp(8, view_date);
            stmt.setString(9, color);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update() throws Exception {
        String sql = "UPDATE passwords SET id_category = ?, service_name = ?, user_name = ?, password = ?, edit_date = ?, view_date = ?, color = ? WHERE id_password = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            stmt.setString(2, service_name);
            stmt.setString(3, user_name);
            stmt.setString(4, MiscHelper.encryptPassword(password));
            stmt.setTimestamp(5, edit_date);
            stmt.setTimestamp(6, view_date);
            stmt.setString(7, color);
            stmt.setInt(8, id_password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete() {
        String sql = "DELETE FROM passwords WHERE id_password = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Password Read(int id_password) throws Exception {
        String sql = "SELECT * FROM passwords WHERE id_password = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Password(
                        rs.getInt("id_password"),
                        rs.getInt("id_user"),
                        rs.getInt("id_category"),
                        rs.getString("service_name"),
                        rs.getString("user_name"),
                        MiscHelper.decryptPassword(rs.getString("password")),
                        rs.getTimestamp("create_date"),
                        rs.getTimestamp("edit_date"),
                        rs.getTimestamp("view_date"),
                        rs.getString("color")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Password> ListFromCategory(int id_category) throws Exception {
        String sql = "SELECT * FROM passwords WHERE id_category = ?";
        ArrayList<Password> passwords = new ArrayList<>();
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                passwords.add(new Password(
                        rs.getInt("id_password"),
                        rs.getInt("id_user"),
                        rs.getInt("id_category"),
                        rs.getString("service_name"),
                        rs.getString("user_name"),
                        MiscHelper.decryptPassword(rs.getString("password")),
                        rs.getTimestamp("create_date"),
                        rs.getTimestamp("edit_date"),
                        rs.getTimestamp("view_date"),
                        rs.getString("color")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passwords;
    }

    public static ArrayList<Password> ListFromUser(int id_user) throws Exception {
        String sql = "SELECT * FROM passwords WHERE id_user = ?";
        ArrayList<Password> passwords = new ArrayList<>();
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                passwords.add(new Password(
                        rs.getInt("id_password"),
                        rs.getInt("id_user"),
                        rs.getInt("id_category"),
                        rs.getString("service_name"),
                        rs.getString("user_name"),
                        MiscHelper.decryptPassword(rs.getString("password")),
                        rs.getTimestamp("create_date"),
                        rs.getTimestamp("edit_date"),
                        rs.getTimestamp("view_date"),
                        rs.getString("color")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passwords;
    }
}
