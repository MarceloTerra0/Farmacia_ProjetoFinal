//Cadastrar farmacias(chefe somente)

package com.klm.farmacia;

import java.sql.*;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class Main{

    public static void main(String[] args){
        String nome = "";
        int idFarmacia = 0;
        float salario = 0;
        String SQLurl = "jdbc:mysql://localhost:3306/farmacia";
        String SQLusername = "root";
        String SQLpassword = "https://www.youtube.com/watch?v=PkiIPzG37vQ";
        try{

            Connection connection = DriverManager.getConnection(SQLurl, SQLusername, SQLpassword);
            System.out.println("Connected to the database.");
            //Armazem.compraEstoque(1, 1, connection);
            //Vendas.mostrarHistoricoVendas(connection);
            Armazem.consultaPrecoEEstoque("Buscopan", 1, connection);
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Criar conta\n2 - Acessar conta->");
            int escolha = scanner.nextInt();

            //String hashedPassword = criarCredenciais.criarSenha();

            if(escolha == 1){
                Cadastro.cadastrarCliente(connection);
                Cadastro.cadastrarFuncionario(3, connection);

            }
            /*
            int idUsuario = -1;
            if(escolha.equals("2")) {
                String sql1 = "SELECT * FROM funcionario WHERE login = ?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setString(1, username);
                ResultSet result = statement1.executeQuery();
                if(result.next()){
                    String senha = result.getString("senha");
                    if (senha.equals(hashedPassword)){
                        idUsuario = result.getInt("id");
                        System.out.println(idUsuario);
                    }else{
                        System.out.println("Usuário ou senha incorreto");
                    }
                }else{
                    System.out.println("Usuário ou senha incorreto");
                }

                statement1.close();
            }
            */
            connection.close();

        } catch(SQLException | NoSuchAlgorithmException e){
            System.out.println("Could not connect to the server.");
            e.printStackTrace();
        }
    }
}