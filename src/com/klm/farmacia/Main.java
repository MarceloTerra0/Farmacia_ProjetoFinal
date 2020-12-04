//Cadastrar farmacias(chefe somente)

package com.klm.farmacia;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.security.NoSuchAlgorithmException;

public class Main{

    public static void main(String[] args){
        String SQLurl = "jdbc:mysql://localhost:3306/farmacia";
        String SQLusername = "root";
        String SQLpassword = "https://www.youtube.com/watch?v=PkiIPzG37vQ";
        try{
            List<Integer> produtos = new ArrayList<Integer>();
            produtos.add(1);
            produtos.add(2);
            List<Integer> qtdProdutos = new ArrayList<Integer>();
            qtdProdutos.add(5);
            qtdProdutos.add(8);
            Connection connection = DriverManager.getConnection(SQLurl, SQLusername, SQLpassword);
            BigDecimal valorCompra = new BigDecimal("827.99");
            Vendas.finalizarVenda(1, 1, 9, 1, valorCompra ,produtos, qtdProdutos, connection);

            System.out.println("Connected to the database.");
            Armazem.consultaPrecoEEstoque("Buscopan", 1, connection);
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Criar conta\n2 - Acessar conta->");
            int escolha = scanner.nextInt();

            if(escolha == 1){
                Cadastro.cadastrarCliente(connection);
                Cadastro.cadastrarFuncionario(3, connection);
            }

            connection.close();
        } catch(SQLException | NoSuchAlgorithmException e){
            System.out.println("Could not connect to the server.");
            e.printStackTrace();
        }
    }
}