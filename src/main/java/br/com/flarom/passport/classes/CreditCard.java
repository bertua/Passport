package br.com.flarom.passport.classes;

import java.sql.Timestamp;

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
    
    
}
