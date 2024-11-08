package br.com.flarom.passport.Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Note {
    private int id_note;
    private int id_user;
    private int id_category;
    private int id_password;
    private String title;
    private String document;
    private Timestamp create_date;
    private Timestamp edit_date;
    private Timestamp view_date;
    
    public Note(){
        
    }
    public Note(int id_note, int id_user, int id_category, int id_password, String title, String document, Timestamp create_date, Timestamp edit_date, Timestamp view_date){
        this.id_note = id_note;
        this.id_user = id_user;
        this.id_category = id_category;
        this.id_password = id_password;
        this.title = title;
        this.document = document;
        this.create_date = create_date;
        this.edit_date = edit_date;
        this.view_date = view_date;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
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

    public int getId_password() {
        return id_password;
    }

    public void setId_password(int id_password) {
        this.id_password = id_password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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
    //</editor-fold>
    
    public void Create() {
        String sql = "INSERT INTO notes (id_user, id_category, id_password, title, document, create_date, edit_date, view_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, id_user);
            stmt.setInt(2, id_category);
            stmt.setInt(3, id_password);
            stmt.setString(4, title);
            stmt.setString(5, document);
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id_note = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        String sql = "UPDATE notes SET id_category = ?, id_password = ?, title = ?, document = ?, edit_date = ? WHERE id_note = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            stmt.setInt(2, id_password);
            stmt.setString(3, title);
            stmt.setString(4, document);
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(6, id_note);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete() {
        String sql = "DELETE FROM notes WHERE id_note = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_note);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Note Read(int id_note) {
        String sql = "SELECT * FROM notes WHERE id_note = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_note);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Note(
                    rs.getInt("id_note"),
                    rs.getInt("id_user"),
                    rs.getInt("id_category"),
                    rs.getInt("id_password"),
                    rs.getString("title"),
                    rs.getString("document"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("edit_date"),
                    rs.getTimestamp("view_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Note> ListFromUser(int id_user) {
        ArrayList<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE id_user = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(new Note(
                    rs.getInt("id_note"),
                    rs.getInt("id_user"),
                    rs.getInt("id_category"),
                    rs.getInt("id_password"),
                    rs.getString("title"),
                    rs.getString("document"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("edit_date"),
                    rs.getTimestamp("view_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static ArrayList<Note> ListFromCategory(int id_category) {
        ArrayList<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes WHERE id_category = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_category);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notes.add(new Note(
                    rs.getInt("id_note"),
                    rs.getInt("id_user"),
                    rs.getInt("id_category"),
                    rs.getInt("id_password"),
                    rs.getString("title"),
                    rs.getString("document"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("edit_date"),
                    rs.getTimestamp("view_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }
}