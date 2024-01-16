package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.controllers.HomeController;
import com.isep.projectjavawallet.controllers.wallets.WalletsListController;

import java.util.ArrayList;

public class UserManager {
    // Home use
    private static HomeController homeController;
    private static Home home;


    // Wallet list use
    private static ArrayList<WalletPane> walletPanes = new ArrayList<>();
    private static WalletsListController walletsListController;
    private static int walletPaneID;











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
}
