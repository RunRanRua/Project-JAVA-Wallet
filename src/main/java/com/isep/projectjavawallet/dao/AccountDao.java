package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.util.DataBase;

import java.sql.*;

public class AccountDao {
    // 1. prepare to connect obj
    Connection con;

    // 2. Prepare a compile obj
    PreparedStatement ps;

    // 3. CRUD
    public Account findAccount(String username) throws SQLException {
        // 1. connect database
        con = DataBase.getConnection();

        // 2. prepare statement
        String searchUser = "SELECT * FROM accounts WHERE username = \"" + username + "\"";
        ps = con.prepareStatement(searchUser);

        // 3. retrieve data
        ResultSet rs = ps.executeQuery();
        String password = "", name = "", mail = "";
        if (rs.next()){
            password = rs.getString("password");
            name = rs.getString("name");
            mail = rs.getString("mail");
        }

        // 4. verify
        if (password.isEmpty() || name.isEmpty() || mail.isEmpty()){
            System.out.println("username: " + username + "   =======> NOT FOUND");
            return null;
        }
        System.out.println("Search successful");
        return new Account(username,password,name,mail);
    }

    public boolean insertAccount(Account account) throws SQLException{
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into accounts values (?,?,?,?)";

        ps = con.prepareStatement(insert);
        ps.setString(1,account.getUsername());
        ps.setString(2,account.getPassword());
        ps.setString(3,account.getName());
        ps.setString(4,account.getMail());

        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Username: " + account.getUsername() + "     ===> Already exist");
            con.close();
            return false;
        }

        System.out.println("Insert Successful");
        con.close();
        return true;
    }

    public boolean modifyPassword(Account account, String newPassword) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();


        // 2. prepare statement
        String stm = "UPDATE accounts " +
                "SET password = \"" + newPassword + "\" " +
                "WHERE username = \"" + account.getUsername() + "\"";
        ps = con.prepareStatement(stm);

        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Failed");
            con.close();
            return false;
        }

        System.out.println("Password is changed");
        con.close();
        return true;
    }

    public boolean modifyMail(Account account, String newMail) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();


        // 2. prepare statement
        String stm = "UPDATE accounts " +
                "SET mail = \"" + newMail + "\" " +
                "WHERE username = \"" + account.getUsername() + "\"";
        ps = con.prepareStatement(stm);

        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            System.out.println("Failed");
            con.close();
            return false;
        }

        System.out.println("Mail is changed");
        con.close();
        return true;
    }



    // Optional
    // public boolean deleteUser(String username){}


}
