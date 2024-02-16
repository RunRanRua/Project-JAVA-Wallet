package com.isep.projectjavawallet.bean.setting;

import com.isep.projectjavawallet.util.AccountVerification;

public class Account {
    private String username;
    private String password;
    private String name;
    private String mail;


    // methods
    public void modifyPWD(String password){
        if(AccountVerification.isValidPWD(password)){
            this.password = password;
        }else{
            System.out.println("modify password failed...");
        }
    }
    public void modifymail(String mail){
        if(AccountVerification.isValidMail(mail)) {
            this.mail = mail;
        }else{
            System.out.println("modify mail failed...");
        }
    }





    // constructors
    public Account(){}

    public Account(String username, String password, String name, String mail) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mail = mail;
    }



    // getters + setters
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
