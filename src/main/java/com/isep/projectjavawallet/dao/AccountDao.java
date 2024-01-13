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
    public boolean insertUser(Account account) throws SQLException{
        boolean isSuccess = false;

        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2- prepare sql code

        // seek MAX(userID)
        String selectMaxID = "SELECT MAX(userID) FROM projectWallet.user";
        ps = con.prepareStatement(selectMaxID);
        ResultSet rs = ps.executeQuery();
        int maxID = 0;
        if (rs.next()){
            maxID = rs.getInt(1);
        }

        // insert code
        String insert = "insert into user values (?,?,?,?,?)";


        // 3- compile
        ps = con.prepareStatement(insert);
        ps.setInt(1,maxID+1);
        ps.setString(2,account.getName());
        ps.setString(3,account.getUsername());
        ps.setString(4,account.getPassword());
        ps.setString(5,account.getMail());
        // 4- execute
        int numExecution = ps.executeUpdate();

        if (numExecution >0){
            isSuccess =true;
        }


        con.close();
        return isSuccess;
    }
}
