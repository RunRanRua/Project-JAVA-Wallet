package com.isep.projectjavawallet.dao;


import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WalletDataDao {
    Connection con;
    PreparedStatement ps;
    public boolean depositAmount(Wallet wallet,double amount) throws SQLException {
        // connect to DB
        con = DataBase.getConnection();

        // prepare statement
        String deposit = "UPDATE wallets " +
                "SET amount = amount + " + amount +
                " WHERE IBAN = \"" + wallet.getIBAN() + "\"";
        System.out.println();

        ps = con.prepareStatement(deposit);

        // execute
        int a = ps.executeUpdate();

        if (a != 0){
            System.out.println("deposit successful");
            con.close();
            ps.close();
            return true;
        }else{
            System.out.println("deposit failed");
            con.close();
            ps.close();
            return false;
        }

    }
}
