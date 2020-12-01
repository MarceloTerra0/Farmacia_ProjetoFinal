package com.klm.farmacia;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;

public class Cadastro {
    public static String cadastrarFuncionario(int idCargo, Connection connection) throws SQLException, NoSuchAlgorithmException {
        //Cargo 3 = Chefe, 2 = Gerente, 1 = Vendedor
        Scanner scanner = new Scanner(System.in);
        int idCargoFuncionarioCadastrar;
        if(idCargo == 3){
            do{
                System.out.println("Cadastrar um:\n1-Vendedor\n2-Gerente");
                idCargoFuncionarioCadastrar = scanner.nextInt();
                if (idCargoFuncionarioCadastrar !=1 && idCargoFuncionarioCadastrar !=2){
                    System.out.println("Opção inválida");
                }
            }while(idCargoFuncionarioCadastrar !=1 && idCargoFuncionarioCadastrar !=2);
        }else if(idCargo == 2){
            idCargoFuncionarioCadastrar = 1;
            System.out.println("Cadastrando vendedor:");
        }else{return("Funcionário não possui permissões necessárias.");}

        System.out.println("Digite o ID da farmácia");
        int idFarmacia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do funcionário");
        String nome = scanner.nextLine();
        System.out.println("Digite o salário do funcionário");
        BigDecimal salario = scanner.nextBigDecimal();
        System.out.println("--Tela do funcionário--");
        String username = criarCredenciais.criarUsername(connection);
        String senha = criarCredenciais.criarSenha();

        String sql = "INSERT INTO funcionario (nome, salario, login, senha, id_farmacia, comissao, cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setBigDecimal(2, salario);
        statement.setString(3, username);
        statement.setString(4, senha);
        statement.setInt(5, idFarmacia);
        //int = 0 == bigDecimal = 0
        statement.setInt(6, 0);
        statement.setInt(7, idCargoFuncionarioCadastrar);
        int rows = statement.executeUpdate();
        if (rows>0){
            System.out.println("Funcionário cadastrado com sucesso!");
        }
        statement.close();
        return ("Usuário cadastrado com sucesso");
    }

    public static String cadastrarCliente(Connection connection) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Cliente");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone de contato do cliente");
        String telefone = scanner.nextLine();
        String sql = "INSERT INTO cliente (nome, telefone, quantidade_compras) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, telefone);
        statement.setInt(3, 0);
        int rows = statement.executeUpdate();
        if (rows>0){
            System.out.println("Cliente cadastrado com sucesso!");
        }
        statement.close();
        return ("Usuário cadastrado com sucesso");

    }
}
