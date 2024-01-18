package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.currency.ExchangeRate;
import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.setting.Account;
import com.isep.projectjavawallet.bean.wallet.CryptoWallet;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.FiatWallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.History;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Asset;
import com.isep.projectjavawallet.dao.CurrencyDao;
import com.isep.projectjavawallet.dao.MarketDao;

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

    public static void loadMarketData(ArrayList<Stock> stocks) throws SQLException {
        UpdateManager.updateMarket();
        String[] symbols = {"IBM","A","AMZN","GOOP","MSFT"};
        Stock stock;
        for (String symbol : symbols) {
            try {
                stock = new MarketDao().findStock(symbol);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            stocks.add(stock);
        }
    }

    public static void loadCurrencyData(ArrayList<ExchangeRate> exchangeRates) throws SQLException {
        UpdateManager.updateCurrency();
        ExchangeRate USD2EUR = new CurrencyDao().findCurrency("USD","EUR");
        ExchangeRate USD2CNY = new CurrencyDao().findCurrency("USD","CNY");
        ExchangeRate EUR2CNY = new CurrencyDao().findCurrency("EUR","CNY");

        exchangeRates.add(USD2EUR);
        exchangeRates.add(USD2CNY);
        exchangeRates.add(EUR2CNY);
    }

}
