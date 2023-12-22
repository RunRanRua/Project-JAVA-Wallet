package com.isep.projectjavawallet.bean;

import com.isep.projectjavawallet.bean.setting.Profil;

public class Home {
    private Profil profil;
    private Market market;
    private Wallet[] wallets;
    private ExchangeRate exchangeRate;


    
    
    
    public Profil getProfil() {
        return profil;
    }

    public Market getMarket() {
        return market;
    }

    public Wallet[] getWallets() {
        return wallets;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }
}
