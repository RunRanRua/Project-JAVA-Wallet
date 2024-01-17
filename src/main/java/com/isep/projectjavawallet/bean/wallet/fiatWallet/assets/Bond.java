package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;

import com.isep.projectjavawallet.bean.currency.FiatCurrency;


/* completed */
public class Bond {
    private final String bondHolder; 
    private final String investor; 
    private final String investorIban; 
    private final double faceValue; 
    private final double coupon; 
    private final RateType rateType; 
    private final FiatCurrency bondCurrency; 
    private final String purchaseDate; 
    private final String maturityDate; 
    


    // constructors
    public Bond(String bondHolder, String investor, String investorIban, double faceValue, double coupon, RateType rateType, FiatCurrency bondCurrency, String purchaseDate, String maturityDate) {
        this.bondHolder = bondHolder;
        this.investor = investor;
        this.investorIban = investorIban;
        this.faceValue = faceValue;
        this.coupon = coupon;
        this.rateType = rateType;
        this.bondCurrency = bondCurrency;
        this.purchaseDate = purchaseDate;
        this.maturityDate = maturityDate;
    }


    // getters

    public String getBondHolder() {
        return bondHolder;
    }

    public String getInvestor() {
        return investor;
    }

    public String getInvestorIban() {
        return investorIban;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public double getCoupon() {
        return coupon;
    }

    public RateType getRateType() {
        return rateType;
    }

    public FiatCurrency getBondCurrency() {
        return bondCurrency;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }
}
