package com.isep.projectjavawallet.bean;


import com.isep.projectjavawallet.bean.market.Market;
import com.isep.projectjavawallet.bean.setting.Profile;
import com.isep.projectjavawallet.bean.market.ExchangeRate;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.dao.WalletDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class Home {
    private Profile profile;
    private Market market;
    private ArrayList<Wallet> wallets;


    // methods
    public void addWallet(Wallet wallet){wallets.add(wallet);}
    public void removeWallet(Wallet wallet){wallets.remove(wallet);}
    public void loadWalletsData() throws SQLException {
        wallets = new WalletDao().loadWallet(profile.getAccount().getUsername());
    }



    // constructors
    public Home(){}
    public Home(Profile profile, Market market, ArrayList<Wallet> wallets) {
        this.profile = profile;
        this.market = market;
        this.wallets = wallets;
    }


    // getters
    public Profile getProfile() {return profile;}
    public Market getMarket() {return market;}
    public ArrayList<Wallet> getWallets() {return wallets;}
}
