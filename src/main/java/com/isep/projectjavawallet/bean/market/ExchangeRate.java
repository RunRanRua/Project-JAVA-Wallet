package com.isep.projectjavawallet.bean.market;

import com.isep.projectjavawallet.util.DateManager;

public class ExchangeRate {
    private final String fromCurrency;
    private final String toCurrency;
    private final double rate;
    private final String date;






    public ExchangeRate(String fromCurrency, String toCurrency, double rate, String date) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
        this.date = date;
    }

    @Override
    public String toString() {
        return "fromCurrency: " + fromCurrency + "\t\t" +
                "toCurrency: " + toCurrency + "\t\t" +
                "rate: " + rate;
    }



    // getters
    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }
}
