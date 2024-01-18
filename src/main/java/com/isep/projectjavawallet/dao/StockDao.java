package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.DataBase;
import com.isep.projectjavawallet.util.UserManager;

import java.sql.*;
import java.util.ArrayList;

public class StockDao {
    Connection con;

    // 2. Prepare a compile obj
    PreparedStatement ps;
    public boolean insertBoughtStocks(Stock stock, String IBAN, String username, String currency) throws SQLException {
            // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into possededstocks values (?,?,?,?,?,?,?,?)";

        ps = con.prepareStatement(insert);
        ps.setString(1, username);
        ps.setString(2, IBAN);
        ps.setString(3, stock.getSymbol());
        ps.setInt(4, stock.getVolume());
        ps.setDouble(5, stock.getPrice());
        ps.setString(6, currency);
        ps.setString(7, stock.getDate());
        ps.setString(8,"Possessed");

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

    public void findStocks(String username, String IBAN, ArrayList<Stock> myAsset_stocks) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String select = "SELECT * FROM possededstocks WHERE username = \"" + username +
                                                        "\" AND IBAN = \"" + IBAN +
                                                        "\" AND status = \"" + "Possessed" +"\"";

        ps = con.prepareStatement(select);

        // 3. execute
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            String symbol = rs.getString("symbol");
            int quantity = rs.getInt("quantity");
            int price = rs.getInt("paid");
            String date = rs.getString("boughtDate");
            Stock stock = new Stock(symbol,price,quantity,date);
            myAsset_stocks.add(stock);
        }
        con.close();
        ps.close();
    }


}
