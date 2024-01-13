package com.isep.projectjavawallet.util;

import com.isep.projectjavawallet.controllers.setting.ProfileController;
import javafx.scene.control.Label;

public class UpdateManager {
    private static ProfileController profileController;


    public static void updateMail(String mail){
        profileController.getMail().setText(mail);
    }





    public static void setProfileController(ProfileController profileController) {
        UpdateManager.profileController = profileController;
    }
}
