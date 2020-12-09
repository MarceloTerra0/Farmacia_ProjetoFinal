package com.klm.farmacia;

import java.sql.*;


public class Main{
    public static void main(String[] args){
        String SQLurl = "jdbc:mysql://localhost:3306/farmacia";
        String SQLusername = "root";
        String SQLpassword = "https://www.youtube.com/watch?v=PkiIPzG37vQ";
        try{
            Connection connection = DriverManager.getConnection(SQLurl, SQLusername, SQLpassword);
            System.out.println("Connected to the database.");

            TelaLogin telaLogin = new TelaLogin(connection);
            telaLogin.initialize();

        } catch(SQLException e){
            System.out.println("Could not connect to the server.");
            e.printStackTrace();
        }
    }
}