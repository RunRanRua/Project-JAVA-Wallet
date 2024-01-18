package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.bean.wallet.Wallet;
import com.isep.projectjavawallet.bean.wallet.fiatWallet.assets.Stock;
import com.isep.projectjavawallet.controllers.HomeController;
import com.isep.projectjavawallet.controllers.wallets.WalletDataController;
import com.isep.projectjavawallet.controllers.wallets.WalletsListController;

import java.util.ArrayList;

public class UserManager {
    // Home use
    private static HomeController homeController;
    private static Home home;


    // Wallet list use
    private static WalletsListController walletsListController;
    private static ArrayList<WalletPane> walletPanes = new ArrayList<>();
    private static int walletPaneID;


    // Wallet data use
    private static WalletDataController walletDataController;
    private static Wallet currentWallet;

    // Buy Stock use
    private static Stock stock;
    private static int stockQuantity;












    public static HomeController getHomeController() {
        return homeController;
    }

    public static void setHomeController(HomeController homeController) {
        UserManager.homeController = homeController;
    }

    public static Home getHome() {
        return home;
    }

    public static void setHome(Home home) {
        UserManager.home = home;
    }

    public static ArrayList<WalletPane> getWalletPanes() {
        return walletPanes;
    }

    public static void setWalletPanes(ArrayList<WalletPane> walletPanes) {
        UserManager.walletPanes = walletPanes;
    }

    public static WalletsListController getWalletsListController() {
        return walletsListController;
    }

    public static void setWalletsListController(WalletsListController walletsListController) {
        UserManager.walletsListController = walletsListController;
    }

    public static int getWalletPaneID() {
        return walletPaneID;
    }

    public static void setWalletPaneID(int walletPaneID) {
        UserManager.walletPaneID = walletPaneID;
    }

    public static Wallet getCurrentWallet() {
        return currentWallet;
    }

    public static void setCurrentWallet(Wallet currentWallet) {
        UserManager.currentWallet = currentWallet;
    }

    public static WalletDataController getWalletDataController() {
        return walletDataController;
    }

    public static void setWalletDataController(WalletDataController walletDataController) {
        UserManager.walletDataController = walletDataController;
    }

    public static Stock getStock() {
        return stock;
    }

    public static void setStock(Stock stock) {
        UserManager.stock = stock;
    }

    public static int getStockQuantity() {
        return stockQuantity;
    }

    public static void setStockQuantity(int stockQuantity) {
        UserManager.stockQuantity = stockQuantity;
    }
}
