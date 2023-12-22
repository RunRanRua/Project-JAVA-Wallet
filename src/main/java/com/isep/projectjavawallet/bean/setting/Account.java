package com.isep.projectjavawallet.bean.setting;

public class Account {
    private String username;
    private String password;
    private String name;
    private String mail;






    // constructors
    public Account(){}

    public Account(String username, String password, String name, String mail) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mail = mail;
    }

    // getters & setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
