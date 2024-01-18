package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.DataBase;
import com.isep.projectjavawallet.util.DateManager;

import java.sql.*;

public class MarketDao {
    Connection con;

    // 2. Prepare a compile obj
    PreparedStatement ps;
    public boolean insertStock(Stock stock) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into markets values (?,?,?,?)";

        ps = con.prepareStatement(insert);
        ps.setString(1, stock.getSymbol());
        ps.setInt(2, stock.getPrice());
        ps.setInt(3, stock.getVolume());
        ps.setString(4, stock.getDate());

        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            ps.close();
            con.close();
            return false;
        }

        System.out.println("Insert Successful");
        con.close();
        ps.close();
        return true;
    }


    public Stock findStock(String symbol) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "SELECT *  FROM markets WHERE symbol = \"" + symbol + "\" AND Date = \"" + DateManager.printDate() + "\"";

        ps = con.prepareStatement(insert);

        // 3- execute
        ResultSet rs = ps.executeQuery();

        Stock stock = new Stock();
        if (rs.next()){
            stock.setSymbol(symbol);
            stock.setPrice(rs.getInt("price"));
            stock.setVolume(rs.getInt("volume"));
            stock.setDate(rs.getString("Date"));
            con.close();
            ps.close();
            return stock;
        }

        con.close();
        ps.close();
        return null;
    }
}
