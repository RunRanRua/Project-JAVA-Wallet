package com.isep.projectjavawallet.bean.wallet.fiatWallet;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Asset;
import com.isep.projectjavawallet.util.UserManager;

import java.util.HashMap;




public class FiatWallet {
    private Asset myAsset;





    // constructors
    public FiatWallet() {
    }


    public FiatWallet(Asset myAsset) {
        this.myAsset = myAsset;
    }

    public Asset getMyAsset() {
        return myAsset;
    }

    public void setMyAsset(Asset myAsset) {
        this.myAsset = myAsset;
    }
}
