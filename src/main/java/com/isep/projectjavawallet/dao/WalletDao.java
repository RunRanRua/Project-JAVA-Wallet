package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.market.ExchangeRate;
import com.isep.projectjavawallet.bean.market.Stock;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.Asset;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.Transaction;
import com.isep.projectjavawallet.util.DataBase;

import java.sql.*;
import java.util.ArrayList;

public class WalletDao {
    Connection con;
    PreparedStatement ps;

    public boolean insertWallet(String username, Wallet wallet) throws SQLException {
        con = DataBase.getConnection();


        // add in wallet DB
        String insert = "insert into wallets values (?, ?, ?, ?)";
        ps = con.prepareStatement(insert);
        ps.setString(1,wallet.getIBAN());           // IBAN
        ps.setString(2,username);   // username
        ps.setString(3,wallet.getWalletName());     // Wname
        ps.setString(4,wallet.getDescription());    // Wdescription

        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }
        System.out.println("Insert wallet Successful");


        // add in fiatWallet DB
        insert = "insert into fiatwallets values (?, ?, ?)";
        ps = con.prepareStatement(insert);
        ps.setString(1,wallet.getIBAN());           // IBAN
        ps.setDouble(2, wallet.getFiatWallet().getBalance());   // balance
        ps.setString(3, wallet.getFiatWallet().getReferenceCurrency().toString());     // currency

        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }
        System.out.println("Insert fiatwallet Successful");
        con.close();
        ps.close();
        return true;
    }
    public boolean removeWallet(String IBAN) throws SQLException {
        con = DataBase.getConnection();

        // Delete from wallets part
        String deleteWallet = "DELETE FROM wallets " +
                              "WHERE (IBAN = \"" + IBAN + "\")";

        ps = con.prepareStatement(deleteWallet);
        try{
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }
        System.out.println("remove wallet successful");


        // Delete from fiatwallets part
        deleteWallet = "DELETE FROM fiatwallets " +
                "WHERE (IBAN = \"" + IBAN + "\")";

        ps = con.prepareStatement(deleteWallet);
        try{
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }
        System.out.println("remove fiatwallet successful");
        con.close();
        ps.close();
        return true;

    }
    public ArrayList<Wallet> loadWallet(String username) throws SQLException {
        con = DataBase.getConnection();
        String statement = "SELECT * FROM wallets, fiatwallets " +
                          "WHERE wallets.IBAN = fiatwallets.IBAN " +
                          "AND username = \"" + username + "\" " +
                          "ORDER BY wname asc";

        ps = con.prepareStatement(statement);
        ResultSet rs = ps.executeQuery();

        ArrayList<Wallet> wallets = new ArrayList<>();

        String wName;
        String wDescription;
        String IBAN;
        double balance;
        while(rs.next()){
            wName = rs.getString("wname");
            wDescription = rs.getString("description");
            IBAN = rs.getString("wallets.IBAN");
            balance = rs.getDouble("balance");

            // load History
            ArrayList<Transaction> transactions = new HistoryDao().loadHistoryData(IBAN);
            // load Asset
            ArrayList<Stock> asset_stock = new AssetDao().loadStocks(IBAN);

            Wallet wallet = new Wallet(wName,
                                       wDescription,
                                       IBAN,
                                       new FiatWallet( balance, new Asset(asset_stock), new History(transactions))
            );
            wallets.add(wallet);
        } while(rs.next()){
            wName = rs.getString("wname");
            wDescription = rs.getString("description");
            IBAN = rs.getString("wallets.IBAN");
            balance = rs.getDouble("balance");

            // load Asset

            // load History
            ArrayList<Transaction> transactions = new HistoryDao().loadHistoryData(IBAN);


            Wallet wallet = new Wallet(wName,
                                       wDescription,
                                       IBAN,
                                       new FiatWallet( balance, new Asset(), new History(transactions))
            );
            wallets.add(wallet);
        }
        con.close();
        ps.close();
        return wallets;

    }
    public Wallet findWallet(String IBAN) throws SQLException {
        con = DataBase.getConnection();
        String statement = "SELECT * FROM wallets,fiatwallets " +
                "WHERE wallets.IBAN = fiatwallets.IBAN " +
                "AND wallets.IBAN = \"" + IBAN + "\"";
        ps = con.prepareStatement(statement);
        ResultSet rs = ps.executeQuery();


        if(rs.next()){

            String wName = rs.getString("wname");
            String wDescription = rs.getString("description");
            double balance = rs.getDouble("balance");

            // load Asset
            ArrayList<Stock> asset_stock = new AssetDao().loadStocks(IBAN);
            // load History
            ArrayList<Transaction> transactions = new HistoryDao().loadHistoryData(IBAN);


            Wallet wallet = new Wallet(wName,
                    wDescription,
                    IBAN,
                    new FiatWallet( balance, new Asset(asset_stock), new History(transactions))
            );
            con.close();
            ps.close();
            return wallet;
        }
        return null;
    }
    public boolean depositWallet(String IBAN, double amount) throws SQLException {
        con = DataBase.getConnection();
        String statement = "UPDATE fiatwallets " +
                            "SET balance = balance + " + amount + " " +
                            "WHERE IBAN = \"" + IBAN + "\"";

        ps = con.prepareStatement(statement);

        try{
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            con.close();
            ps.close();
            return false;
        }
        con.close();
        ps.close();
        return true;
    }





    public static void main(String[] args) throws SQLException {
        Wallet wallet = new Wallet("WWW0","testdescription","XXXXX",new FiatWallet());

        new WalletDao().findWallet("XXXXX");
    }
}
