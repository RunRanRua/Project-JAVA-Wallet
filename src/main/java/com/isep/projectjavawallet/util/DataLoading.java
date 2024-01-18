package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.wallet.CryptoWallet;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataLoading {
    private static Connection con;
    private static PreparedStatement ps;


    public static void loadWalletData(String username, ArrayList<Wallet> wallets) throws SQLException {
        // 1. connect database
        con = DataBase.getConnection();

        // 2. prepare statement
        String searchUser = "SELECT * FROM wallets WHERE username = \"" + username + "\" ORDER BY Wid ASC";
        ps = con.prepareStatement(searchUser);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String Wname = rs.getString("Wname");
            String Wdescription = rs.getString("Wdescription");
            String IBAN = rs.getString("IBAN");
            double amount = rs.getDouble("amount");
            String refCurrency = rs.getString("refCurrency");


            // FiatWallet, History need to be initialized

            // FiatWallet:
            FiatWallet fiatWallet = new FiatWallet(new HashMap<FiatCurrency,Double>(), new Asset(new ArrayList<Stock>()));

            // History:

            Wallet wallet = new Wallet(Wname, Wdescription, IBAN, amount, refCurrency, fiatWallet,new CryptoWallet(), new History());

            wallets.add(wallet);
        }


        con.close();
        ps.close();
    }


    public Account findAccount(String username) throws SQLException {
        // 1. connect database
        con = DataBase.getConnection();

        // 2. prepare statement
        String searchUser = "SELECT * FROM accounts WHERE username = \"" + username + "\"";
        ps = con.prepareStatement(searchUser);

        // 3. retrieve data
        ResultSet rs = ps.executeQuery();
        String password = "", name = "", mail = "";
        if (rs.next()){
            password = rs.getString("password");
            name = rs.getString("name");
            mail = rs.getString("mail");
        }

        // 4. verify
        if (password.isEmpty() || name.isEmpty() || mail.isEmpty()){
            System.out.println("username: " + username + "   =======> NOT FOUND");
            return null;
        }
        System.out.println("Search successful");

        con.close();
        ps.close();
        return new Account(username,password,name,mail);
    }

}
