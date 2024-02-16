package com.isep.projectjavawallet.bean.wallet;

import com.isep.projectjavawallet.bean.wallet.fiaWallet.FiatWallet;

public class Wallet {
    private final String walletName;
    private final String description;
    private final String IBAN;
    private final FiatWallet fiatWallet;






    public Wallet(String walletName, String description, String IBAN, FiatWallet fiatWallet) {
        this.walletName = walletName;
        this.description = description;
        this.IBAN = IBAN;
        this.fiatWallet = fiatWallet;
    }



    // Getters
    public String getWalletName() {
        return walletName;
    }

    public String getDescription() {
        return description;
    }

    public String getIBAN() {
        return IBAN;
    }

    public FiatWallet getFiatWallet() {
        return fiatWallet;
    }
}
