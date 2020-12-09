package com.klm.farmacia;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;

public class Cadastro {
    //Função não utilizada no projeto final. E por estar descontinuada,
    //sua implementação provavelmente necessitaria de mudanças. (Também possui código para inserção de dados sem a UI)
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
        String username = CriarCredenciais.criarUsername(connection);
        String senha = CriarCredenciais.criarSenha();

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

    public static String cadastrarCliente(String nome,String telefone, String CPF, Connection connection) throws SQLException{
        String cadastrarClienteSQL = "INSERT INTO cliente (nome, telefone, quantidade_compras, cpf) VALUES (?, ?, ?, ?)";
        PreparedStatement cadastrarClienteStatement = connection.prepareStatement(cadastrarClienteSQL);
        cadastrarClienteStatement.setString(1, nome);
        cadastrarClienteStatement.setString(2, telefone);
        cadastrarClienteStatement.setInt(3, 0);
        cadastrarClienteStatement.setString(4, CPF);
        int rows = cadastrarClienteStatement.executeUpdate();
        if (rows>0){
            return("Cliente cadastrado com sucesso!");
        }
        cadastrarClienteStatement.close();
        return ("Erro ao cadastrar o cliente");
    }
}
