package com.isep.projectjavawallet.util;

import java.util.regex.Pattern;

public class AccountVerification {
    public static boolean isValidName(String name){
        return !name.isEmpty() && Pattern.matches("( )?[a-zA-z]+", name);
    }
    public static boolean isValidUsername(String username){
        return !username.isEmpty() && Pattern.matches("^.{3,15}$", username);
    }
    public static boolean isValidPWD(String pwd){
        return !pwd.isEmpty() && Pattern.matches("^.{6,15}$",pwd);
    }
    public static boolean isValidMail(String mail){
        return !mail.isEmpty() && Pattern.matches("^[a-zA-Z0-9]+@[a-z]+.[a-z]+$",mail);
    }
    public static boolean isSamePWD(String pwd, String confirmPWD){
        return pwd.equals(confirmPWD);
    }

}
