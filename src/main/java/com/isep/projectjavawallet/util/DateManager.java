package com.isep.projectjavawallet.util;

import java.text.SimpleDateFormat;

public class DateManager {
    public static String getDate(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    public static String getPreciseDate(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return dateFormat.format(date);
    }


    public static void main(String[] args) {
        System.out.println(getPreciseDate());
    }
}
