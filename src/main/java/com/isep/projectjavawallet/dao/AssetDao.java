package com.isep.projectjavawallet.dao;



import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.util.DataBase;


import java.sql.*;
import java.util.ArrayList;

public class AssetDao {
    Connection con;
    PreparedStatement ps;

    public boolean insertStock(String IBAN, String symbol, int quantity) throws SQLException {
            // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into stocks (IBAN,symbol,quantity) values (?,?,?)";
        ps = con.prepareStatement(insert);
        ps.setString(1, IBAN);
        ps.setString(2, symbol);
        ps.setInt(3, quantity);

        // 3- execute
        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            ps.close();
            con.close();
            return false;
        }
        con.close();
        ps.close();
        return true;
    }
    public ArrayList<Stock> loadStocks(String IBAN) throws SQLException {
        con = DataBase.getConnection();
        String select = "SELECT * FROM stocks WHERE IBAN = \"" +IBAN + "\"";
        ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();


        ArrayList<Stock> stocks = new ArrayList<>();
        while (rs.next()){
            String symbol = rs.getString("symbol");
            int quantity = rs.getInt("quantity");

            Stock stock = new Stock(symbol,0,quantity,null);
            stocks.add(stock);
        }
        con.close();
        ps.close();
        return stocks;
    }
    public boolean isStockExist(String IBAN, String symbol) throws SQLException {
        con = DataBase.getConnection();
        String select = "SELECT * FROM stocks " +
                "WHERE IBAN = \"" +IBAN + "\" " +
                "AND symbol = \"" + symbol + "\"";

        ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            con.close();
            ps.close();
            return true;
        }
        con.close();
        ps.close();
        return false;
    }
    public void updateStockQuantity(String IBAN, String symbol, int quantity) throws SQLException {
        con = DataBase.getConnection();

        String statement = "UPDATE stocks " +
                "SET quantity = quantity + " + quantity +
                " WHERE symbol = \"" + symbol + "\" AND IBAN = \"" + IBAN + "\"";

        ps = con.prepareStatement(statement);

        ps.executeUpdate();
        con.close();
        ps.close();
    }
    public void remove0QuantityStock() throws SQLException {
        con = DataBase.getConnection();

        String statement = "DELETE FROM stocks WHERE quantity = 0";

        ps = con.prepareStatement(statement);

        ps.executeUpdate();
        con.close();
        ps.close();
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Stock> stocks = new AssetDao().loadStocks("X");
        for (Stock s : stocks){
            System.out.println(s.toString_own());
        }
    }

}
