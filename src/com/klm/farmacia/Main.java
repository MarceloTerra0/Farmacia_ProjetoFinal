//Cadastrar farmacias(chefe somente)

package com.klm.farmacia;

import com.klm.farmacia.obj.Funcionario;
import com.klm.farmacia.obj.HistoricoVendas;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String SQLurl = "jdbc:mysql://localhost:3306/farmacia";
        String SQLusername = "root";
        String SQLpassword = "https://www.youtube.com/watch?v=PkiIPzG37vQ";
        try{

            /*
            DEBUG

            List<Integer> produtos = new ArrayList<>();
            produtos.add(1);
            produtos.add(2);
            List<Integer> qtdProdutos = new ArrayList<>();
            qtdProdutos.add(5);
            qtdProdutos.add(8);
            BigDecimal valorCompra = new BigDecimal("800.00");
            */

            Connection connection = DriverManager.getConnection(SQLurl, SQLusername, SQLpassword);
            System.out.println("Connected to the database.");

            Login telaLogin = new Login(connection);
            telaLogin.initialize();

            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

        } catch(SQLException e){
            System.out.println("Could not connect to the server.");
            e.printStackTrace();
        }
    }
}