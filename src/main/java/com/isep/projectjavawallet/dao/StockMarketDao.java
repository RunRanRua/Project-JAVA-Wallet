package com.isep.projectjavawallet.dao;


import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.util.DataBase;
import com.isep.projectjavawallet.util.DateManager;

import java.sql.*;

public class StockMarketDao {
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
        ps.setInt(3, stock.getQuantity());
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

    public void removeStock(String symbol, int quantity) throws SQLException {
        con = DataBase.getConnection();

        String statement = "UPDATE markets " +
                            "SET volume = volume - " + quantity +
                            " WHERE symbol = \"" + symbol + "\" AND date = \"" + DateManager.getDate() + "\"";

        ps = con.prepareStatement(statement);

        ps.executeUpdate();

        con.close();
        ps.close();
    }


    public Stock findStock(String symbol) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String statement = "SELECT *  FROM markets WHERE symbol = \"" + symbol + "\" AND Date = \"" + DateManager.getDate() + "\"";

        ps = con.prepareStatement(statement);

        // 3- execute
        ResultSet rs = ps.executeQuery();

        int price;
        int volume;
        String date;
        if (rs.next()){
            price = rs.getInt("price");
            volume = rs.getInt("volume");
            date = rs.getString("date");
            con.close();
            ps.close();
            return new Stock(symbol,price,volume,date);
        }

        con.close();
        ps.close();
        return null;
    }

    public boolean isStockUpdated(String symbol) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String statement = "SELECT *  FROM markets WHERE symbol = \"" + symbol + "\" AND Date = \"" + DateManager.getDate() + "\"";

        ps = con.prepareStatement(statement);

        // 3- execute
        ResultSet rs = ps.executeQuery();

        boolean ans = rs.next();

        con.close();
        ps.close();
        return ans;
    }

    public boolean isSymbolExist(String symbol) throws SQLException {
        con = DataBase.getConnection();

        String statement = "SELECT symbol FROM markets WHERE symbol = \"" + symbol + "\"";
        ps = con.prepareStatement(statement);

        ResultSet rs = ps.executeQuery();
        boolean ans = rs.next();

        con.close();
        ps.close();
        return ans;
    }
}
