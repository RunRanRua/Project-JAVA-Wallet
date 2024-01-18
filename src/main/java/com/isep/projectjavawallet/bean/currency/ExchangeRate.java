package com.isep.projectjavawallet.bean.currency;

public class ExchangeRate {
    private String fromCurrency;
    private String toCurrency;
    private double rate;
    private  String date;




    @Override
    public String toString() {
        return "fromCurrency: " + fromCurrency + "\t\t" +
                "toCurrency: " + toCurrency + "\t\t" +
                "rate: " + rate;
    }

    public ExchangeRate() {

    }

    public ExchangeRate(String fromCurrency, String toCurrency, double rate, String date) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
        this.date = date;
    }


    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
