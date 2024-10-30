package com.mycompany.contatos.classes;

/*
    Contact class
    use to store data from a contact
*/

public class Contact {

    private String name;
    private String telephone;
    private String email;
    private String address;
    private String category;

    public Contact(){
        
    }
    
    public Contact(String name, String telephone, String email, String address, String category){
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.category = category;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Getters and Setters ">
    
    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // e-mail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    //</editor-fold>
}
