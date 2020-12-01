
//Cadastrar cliente (nome + CPF + telefone)
package com.klm.farmacia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class criarCredenciais {
    public static String hashSenha(String password) throws NoSuchAlgorithmException {
        //Trecho de código retirado de:
        //https://github.com/VoxelPixel/HashingAlgorithmsInJava/blob/master/SHA512.java
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return(sb.toString());
    }
    public static String criarSenha() throws NoSuchAlgorithmException {
        boolean repetir = false;
        String senha, senhaConfirmada;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite sua senha");
            senha = scanner.nextLine();
            System.out.println("Confirme sua senha");
            senhaConfirmada = scanner.nextLine();
            if(!senha.equals(senhaConfirmada)){
                System.out.println("As duas senhas são diferentes!");
            }
        }while(!senha.equals(senhaConfirmada));

        return hashSenha(senha);
    }
    public static String criarUsername(Connection connection) throws SQLException {
        boolean repetir;
        Scanner scanner = new Scanner(System.in);
        String username;
        do {
            repetir = false;
            System.out.println("Digite seu login");
            username = scanner.nextLine();
            String sql1 = "SELECT * FROM funcionario WHERE login = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, username);
            ResultSet result = statement1.executeQuery();
            if (result.next()) {
                repetir = true;
                System.out.println("Login já cadastrado no sistema");
            }else{statement1.close();}
        }while(repetir);
        return username;
    }
}
