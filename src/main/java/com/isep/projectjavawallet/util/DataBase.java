package com.isep.projectjavawallet.util;

import java.sql.*;

public class DataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/projectWallet?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // depending your settings of MySQL
    static final String USER = "root";
    static final String PWD = "123456";


    static{
        // Import SQL
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // Connect SQL
    public static Connection getConnection() {
        Connection con = null;

        try{
            System.out.println("Connecting to DataBase...");
            con = DriverManager.getConnection(DB_URL,USER,PWD);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println(con);
        System.out.println("Successful");
    }

}
