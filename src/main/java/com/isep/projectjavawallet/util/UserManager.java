package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.bean.Home;
import com.isep.projectjavawallet.controllers.HomeController;

public class UserManager {
    static HomeController homeController;
    static Home home;











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
}
