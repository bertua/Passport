package br.com.flarom.passport.Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category {

    private int id_category;
    private int id_user;
    private String name;
    private String color;

    public Category() {
    }

    public Category(int id_user, String name, String color) {
        this.id_user = id_user;
        this.name = name;
        this.color = color;
    }

    public Category(int id_category, int id_user, String name, String color) {
        this.id_category = id_category;
        this.id_user = id_user;
        this.name = name;
        this.color = color;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //</editor-fold>

    public void Create() {
        String sql = "INSERT INTO categories (id_user, name, color) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            stmt.setString(2, name);
            stmt.setString(3, color != null ? color : "#2285E1"); // default color
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        String sql = "UPDATE categories SET name = ?, color = ? WHERE id_category = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, color);
            stmt.setInt(3, id_category);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete() {
        String sql = "DELETE FROM categories WHERE id_category = ?";
        String sqlp = "UPDATE passwords SET id_category = NULL WHERE id_category = ?";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtp = conn.prepareStatement(sqlp)) {
                stmtp.setInt(1, id_category);
                stmtp.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id_category);
                stmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = Database.getConnection()) {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try (Connection conn = Database.getConnection()) {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Category Read(int id_category) {
        String sql = "SELECT * FROM categories WHERE id_category = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Category(
                        rs.getInt("id_category"),
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("color")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Category> ListFromUser(int id_user) {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories WHERE id_user = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id_category"),
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("color")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static int Count(int id_category) {
        String sql = "SELECT COUNT(*) AS count FROM passwords WHERE id_category = ? "
                + "UNION ALL "
                + "SELECT COUNT(*) FROM notes WHERE id_category = ?";
        int count = 0;
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            stmt.setInt(2, id_category);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                count += rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
