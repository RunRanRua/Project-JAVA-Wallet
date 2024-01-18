package com.isep.projectjavawallet.dao;


import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDataDao {
    Connection con;
    PreparedStatement ps;

    public boolean depositAmount(Wallet wallet, double amount) throws SQLException {
        // connect to DB
        con = DataBase.getConnection();

        // prepare statement
        String deposit = "UPDATE wallets " +
                "SET amount = amount + " + amount +
                " WHERE IBAN = \"" + wallet.getIBAN() + "\"";

        ps = con.prepareStatement(deposit);

        // execute
        int a = ps.executeUpdate();

        if (a != 0){
            System.out.println("deposit amount successful");
            con.close();
            ps.close();
            return true;
        }else{
            System.out.println("deposit amount failed");
            con.close();
            ps.close();
            return false;
        }
    }

    public boolean addAmount(String IBAN, double amount) throws SQLException {
        // connect to DB
        con = DataBase.getConnection();

        // prepare statement
        String deposit = "UPDATE wallets " +
                "SET amount = amount + " + amount +
                " WHERE IBAN = \"" + IBAN + "\"";

        ps = con.prepareStatement(deposit);

        // execute
        int a = ps.executeUpdate();

        if (a != 0){
            System.out.println("add amount successful");
            con.close();
            ps.close();
            return true;
        }else{
            System.out.println("add amount failed");
            con.close();
            ps.close();
            return false;
        }

    }

    public boolean removeAmount(Wallet wallet, double amount) throws SQLException {
        // connect to DB
        con = DataBase.getConnection();

        // prepare statement
        String deposit = "UPDATE wallets " +
                "SET amount = amount - " + amount +
                " WHERE IBAN = \"" + wallet.getIBAN() + "\"";

        ps = con.prepareStatement(deposit);

        // execute
        int a = ps.executeUpdate();

        if (a != 0){
            System.out.println("remove amount successful");
            con.close();
            ps.close();
            return true;
        }else{
            System.out.println("remove amount failed");
            con.close();
            ps.close();
            return false;
        }
    }


    public boolean isIBANExist(String IBAN) throws SQLException {
        // connect to DB
        con = DataBase.getConnection();

        // prepare statement
        String deposit = "SELECT IBAN FROM wallets WHERE IBAN = \"" + IBAN + "\"";

        ps = con.prepareStatement(deposit);

        // execute
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            return true;
        }
        return false;

    }
}
