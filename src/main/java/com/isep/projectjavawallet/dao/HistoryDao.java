package com.isep.projectjavawallet.dao;

import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.Asset;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.Transaction;
import com.isep.projectjavawallet.bean.wallet.fiaWallet.transaction.TransactionType;
import com.isep.projectjavawallet.util.DataBase;
import com.isep.projectjavawallet.util.DateManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class HistoryDao{
    Connection con;
    PreparedStatement ps;
    public boolean insertHistoryData(Wallet wallet, TransactionType type) throws SQLException {
        con = DataBase.getConnection();


        // add in history DB
        String insert = "INSERT INTO history (IBAN,transactionType, remainingBalance, date) " +
                        "VALUES (?,?,?,?)";

        ps = con.prepareStatement(insert);
        ps.setString(1,wallet.getIBAN());           // IBAN
        ps.setString(2,type.toString());
        ps.setDouble(3,wallet.getFiatWallet().getBalance());   // balance
        ps.setString(4, DateManager.getPreciseDate());     // date

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

    public ArrayList<Transaction> loadHistoryData(String IBAN) throws SQLException {
        con = DataBase.getConnection();
        String statement = "SELECT * FROM history " +
                "WHERE IBAN = \"" + IBAN + "\" " +
                "ORDER BY date asc";

        ps = con.prepareStatement(statement);
        ResultSet rs = ps.executeQuery();

        ArrayList<Transaction> transactions = new ArrayList<>();

        String transactionType;
        double remainingBalance;
        String date;
        while(rs.next()){
            transactionType = rs.getString("transactionType");
            remainingBalance = rs.getDouble("remainingBalance");
            date = rs.getString("date");

            TransactionType type = new Transaction().toTransactionType(transactionType);

            Transaction transaction = new Transaction(type,date,remainingBalance);
            transactions.add(transaction);
        }
        con.close();
        ps.close();

        return transactions;
    }



    public static void main(String[] args) throws SQLException {
        ArrayList<Transaction> transactions = new HistoryDao().loadHistoryData("X");
        for(Transaction transaction:transactions){
            System.out.println(transaction.toString());
        }
    }
}
