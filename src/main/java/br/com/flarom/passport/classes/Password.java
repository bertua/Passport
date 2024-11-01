package br.com.flarom.passport.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Password {

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getEditDate() {
        return editDate;
    }

    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
    }

    public Timestamp getViewDate() {
        return viewDate;
    }

    public void setViewDate(Timestamp viewDate) {
        this.viewDate = viewDate;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    // </editor-fold>

    private int id;
    private String serviceName;
    private String userName;
    private String password;
    private Timestamp createDate;
    private Timestamp editDate;
    private Timestamp viewDate;
    private int id_category;
    private String color;

    public static ArrayList<Password> readAll() {
        Connection conn = Database.getConnection();
        ArrayList<Password> passwords = new ArrayList<>();
        
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM passwords");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Password password = new Password();
                password.setId(rs.getInt("id_password"));
                password.setServiceName(rs.getString("service_name"));
                password.setUserName(rs.getString("username"));
                password.setPassword(rs.getString("password"));
                password.setCreateDate(rs.getTimestamp("create_date"));
                password.setEditDate(rs.getTimestamp("edit_date"));
                password.setViewDate(rs.getTimestamp("view_date"));
                password.setId_category(rs.getInt("id_category"));
                password.setColor(rs.getString("color"));

                passwords.add(password);
            }
            
            return passwords;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static ArrayList<Password> readFromCategory(int id_category) {
        Connection conn = Database.getConnection();
        ArrayList<Password> passwords = new ArrayList<>();
        
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM passwords WHERE id_category = ?");
            pstm.setInt(1,id_category);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Password password = new Password();
                password.setId(rs.getInt("id_password"));
                password.setServiceName(rs.getString("service_name"));
                password.setUserName(rs.getString("username"));
                password.setPassword(rs.getString("password"));
                password.setCreateDate(rs.getTimestamp("create_date"));
                password.setEditDate(rs.getTimestamp("edit_date"));
                password.setViewDate(rs.getTimestamp("view_date"));
                password.setId_category(rs.getInt("id_category"));
                password.setColor(rs.getString("color"));

                passwords.add(password);
            }
            
            return passwords;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static Password read(int id){
        Connection conn = Database.getConnection();
        
        try {
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM passwords WHERE id_password=?");
            pstm.setInt(1,id);
            pstm.execute();
            ResultSet rs = pstm.executeQuery();
            
            Password password = new Password();
            password.setId(rs.getInt("id_password"));
            password.setServiceName(rs.getString("service_name"));
            password.setUserName(rs.getString("username"));
            password.setPassword(rs.getString("password"));
            password.setCreateDate(rs.getTimestamp("create_date"));
            password.setEditDate(rs.getTimestamp("edit_date"));
            password.setViewDate(rs.getTimestamp("view_date"));
            password.setId_category(rs.getInt("id_category"));
            password.setColor(rs.getString("color"));

            return password;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void create(){
        Connection conn = Database.getConnection();
        try{
            PreparedStatement pstm = conn.prepareStatement("INSET INTO passwords (id_password,service_name,username,passwrod,create_date,edit_date,view_date,id_category,color) VALUES (?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, this.getId());
            pstm.setString(2, this.getServiceName());
            pstm.setString(3, this.getUserName());
            pstm.setString(4, this.getPassword());
            pstm.setTimestamp(5, this.getCreateDate());
            pstm.setTimestamp(6, this.getEditDate());
            pstm.setTimestamp(7, this.getViewDate());
            pstm.setInt(8, this.getId_category());
            pstm.setString(9, this.getColor());
            
            pstm.execute();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        Connection conn = Database.getConnection();
        try{
            PreparedStatement pstm = conn.prepareStatement("UPDATE passwords SET service_name=?,username=?,password=?,create_date=?,edit_date=?,view_date=?,id_category=?,color=? WHERE id_password=?");
            pstm.setInt(9, this.getId());
            pstm.setString(1, this.getServiceName());
            pstm.setString(2, this.getUserName());
            pstm.setString(3, this.getPassword());
            pstm.setTimestamp(4, this.getCreateDate());
            pstm.setTimestamp(5, this.getEditDate());
            pstm.setTimestamp(6, this.getViewDate());
            pstm.setInt(7, this.getId_category());
            pstm.setString(8, this.getColor());
            
            pstm.execute();
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void delete(int id){
        Connection conn = Database.getConnection();
        try{
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM passwords WHERE id_password=?");
            pstm.setInt(1, id);
            pstm.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
