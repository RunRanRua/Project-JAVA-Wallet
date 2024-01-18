package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;


import com.isep.projectjavawallet.util.DateManager;





/*  Completed */
public class Stock {
   private String symbol;
   private int price;
   private int volume;
   private String date = DateManager.printDate();


    @Override
    public String toString() {
        return symbol + "\t\t"
                + date + "\t\t"
                + " price: " + price + " USD\t\t"
                + " volume: " + volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
