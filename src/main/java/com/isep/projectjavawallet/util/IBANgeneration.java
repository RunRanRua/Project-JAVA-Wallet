package com.isep.projectjavawallet.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class IBANgeneration {

    public static String generateIBAN() throws SQLException {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        // generate a random IBAN
        StringBuilder randomIBAN = new StringBuilder(27);
        do {
            for (int i = 0; i < 27; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                randomIBAN.append(randomChar);
            }
        }while (isIBANExisted(randomIBAN.toString()));

        return randomIBAN.toString();
    }

    public static boolean isIBANExisted(String IBAN) throws SQLException {
        Connection con = DataBase.getConnection();

        String selectIBAN = "SELECT IBAN from wallets";
        PreparedStatement ps = con.prepareStatement(selectIBAN);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if ( IBAN.equals(rs.getString("IBAN")) ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(generateIBAN());
    }
}
