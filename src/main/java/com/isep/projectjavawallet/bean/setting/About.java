package com.isep.projectjavawallet.bean.setting;

public class About {
    private static String aboutApp;
    private static String aboutTeam;






    // constructor
    public About(){
        aboutApp = "our APP is not released yet";
        aboutTeam = "We are G10 JAVA trinome team";
    }

    // getters
    public String getAboutApp() {
        return aboutApp;
    }

    public String getAboutTeam() {
        return aboutTeam;
    }
}
