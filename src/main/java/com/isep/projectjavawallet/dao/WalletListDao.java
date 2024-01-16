package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.DataBase;

import java.sql.*;

public class WalletListDao {
    Connection con;
    PreparedStatement ps;

    public boolean insertWallet(String username, Wallet wallet) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into wallets values (?, ?, ?, ?, ?, ?, ?)";
        int currentWID = maxWID(username) + 1;
        ps = con.prepareStatement(insert);
        ps.setString(1,username);   // username
        ps.setString(2,wallet.getWalletName());     // Wname
        ps.setString(3,wallet.getDescription());    // Wdescription
        ps.setInt(4,currentWID);    // wid
        ps.setString(5,wallet.getIBAN());           // IBAN
        ps.setDouble(6,wallet.getAmount());           // amount
        ps.setString(7,wallet.getReferenceCurrency());   // reference currency


        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }

        System.out.println("Insert Successful");
        con.close();
        ps.close();
        return true;
    }


    /*
    public boolean removeWallet(String username, int Wid){
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String deleteWallet = "DELETE FROM wallets " +
                "WHERE (username = \""+  username + "\"" +
                "AND Wid = " +  Wid + ")";


        return true;
    }
     */




    // Obtain maxID
    private int maxWID(String username) throws SQLException {
        con = DataBase.getConnection();

        String selectWID = "SELECT max(Wid) FROM projectWallet.wallets where username = \"" + username + "\"" ;
        ps = con.prepareStatement(selectWID);

        ResultSet rs = ps.executeQuery();
        rs.next();
        int ID = rs.getInt("max(Wid)");
        return ID;
    }

}
