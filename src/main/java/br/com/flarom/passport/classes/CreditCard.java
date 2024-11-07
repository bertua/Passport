package br.com.flarom.passport.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CreditCard {
    private int id_credit_card;
    private int id_user;
    private String number;
    private String cvv;
    private String expiration_date;
    private String holder;
    private Timestamp creation_date;
    private Timestamp view_date;
    
    public CreditCard(){
        
    }
    public CreditCard(int id_credit_card, int id_user, String number, String cvv, String expiration_date, String holder, Timestamp creation_date, Timestamp view_date){
        this.id_credit_card = id_credit_card;
        this.id_user = id_user;
        this.number = number;
        this.cvv = cvv;
        this.expiration_date = expiration_date;
        this.holder = holder;
        this.creation_date = creation_date;
        this.view_date = view_date;
    }

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getId_credit_card() {
        return id_credit_card;
    }

    public void setId_credit_card(int id_credit_card) {
        this.id_credit_card = id_credit_card;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getView_date() {
        return view_date;
    }

    public void setView_date(Timestamp view_date) {
        this.view_date = view_date;
    }
    //</editor-fold>

    public void Create() throws Exception {
        String sql = "INSERT INTO credit_cards (id_user, number, cvv, expiration_date, holder, create_date, view_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, id_user);
            stmt.setString(2, MiscTools.encryptPassword(number));
            stmt.setString(3, MiscTools.encryptPassword(cvv));
            stmt.setString(4, expiration_date);
            stmt.setString(5, holder);
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id_credit_card = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Delete() {
        String sql = "DELETE FROM credit_cards WHERE id_credit_card = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_credit_card);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static CreditCard Read(int id_credit_card) throws Exception {
        String sql = "SELECT * FROM credit_cards WHERE id_credit_card = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_credit_card);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new CreditCard(
                    rs.getInt("id_credit_card"),
                    rs.getInt("id_user"),
                    MiscTools.decryptPassword(rs.getString("number")),
                    MiscTools.decryptPassword(rs.getString("cvv")),
                    rs.getString("expiration_date"),
                    rs.getString("holder"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("view_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<CreditCard> ListFromUser(int id_user) throws Exception {
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        String sql = "SELECT * FROM credit_cards WHERE id_user = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                creditCards.add(new CreditCard(
                    rs.getInt("id_credit_card"),
                    rs.getInt("id_user"),
                    MiscTools.decryptPassword(rs.getString("number")),
                    MiscTools.decryptPassword(rs.getString("cvv")),
                    rs.getString("expiration_date"),
                    rs.getString("holder"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("view_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditCards;
    }
}