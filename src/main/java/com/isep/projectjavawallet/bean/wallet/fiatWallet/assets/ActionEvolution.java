package com.isep.projectjavawallet.bean.wallet.fiatWallet.assets;



/* completed */
public class ActionEvolution {
    private final double currentPrice; 
    private final double totalEarning; 
    private final double yield;
    private final String currentDate;







    // constructors
    public ActionEvolution(double currentPrice, double totalEarning, double yield, String currentDate) {
        this.currentPrice = currentPrice;
        this.totalEarning = totalEarning;
        this.yield = yield;
        this.currentDate = currentDate;
    }

    // getters
    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getTotalEarning() {
        return totalEarning;
    }

    public double getYield() {
        return yield;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}
