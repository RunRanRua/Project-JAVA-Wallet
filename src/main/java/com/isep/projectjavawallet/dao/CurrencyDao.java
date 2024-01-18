package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.util.DataBase;
import com.isep.projectjavawallet.util.DateManager;

import java.sql.*;

public class CurrencyDao {
    Connection con;

    // 2. Prepare a compile obj
    PreparedStatement ps;

    public boolean insertRate(ExchangeRate rate) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String insert = "insert into currencies values (?,?,?,?)";

        ps = con.prepareStatement(insert);
        ps.setString(1,rate.getFromCurrency());
        ps.setString(2, rate.getToCurrency());
        ps.setDouble(3, rate.getRate());
        ps.setString(4, rate.getDate());

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

    public boolean isRateUpdated(String fromCurrency, String toCurrency) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String statement = "SELECT *  FROM currencies WHERE fromCurrency = \"" + fromCurrency
                                                    + "\" AND toCurrency = \"" + toCurrency
                                                    +"\" AND Date = \"" + DateManager.getDate() + "\"";

        ps = con.prepareStatement(statement);

        // 3- execute
        ResultSet rs = ps.executeQuery();
        boolean ans = rs.next();

        con.close();
        ps.close();
        return ans;
    }

    public ExchangeRate findCurrency(String fromCurrency, String toCurrency) throws SQLException {
        // 1- Start connect dataBase
        con = DataBase.getConnection();

        // 2. prepare statement
        String statement = "SELECT * FROM currencies WHERE fromCurrency = \"" + fromCurrency
                                                      + "\" AND toCurrency = \"" + toCurrency
                                                      + "\" AND Date = \"" + DateManager.getDate() + "\"";

        ps = con.prepareStatement(statement);

        // 3- execute
        ResultSet rs = ps.executeQuery();

        ExchangeRate exchangeRate = new ExchangeRate();
        if (rs.next()){
            exchangeRate.setFromCurrency(fromCurrency);
            exchangeRate.setToCurrency(toCurrency);
            exchangeRate.setRate(Double.parseDouble(rs.getString("rate")));
            exchangeRate.setDate(rs.getString("date"));
            con.close();
            ps.close();
            return exchangeRate;
        }
        con.close();
        ps.close();
        return null;
    }
}
