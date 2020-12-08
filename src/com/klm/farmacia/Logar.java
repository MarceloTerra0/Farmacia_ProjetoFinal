package com.klm.farmacia;

import com.klm.farmacia.obj.Funcionario;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logar {
    public static Funcionario login(String username, String senha, Connection connection) throws SQLException, NoSuchAlgorithmException {
        String sql = "SELECT funcionario.login, funcionario.senha, funcionario.nome, farmacias.nome_farmacia," +
                " funcionario.id_farmacia, funcionario.cargo FROM farmacia.funcionario INNER JOIN farmacia.farmacias" +
                " ON funcionario.id_farmacia=farmacias.id_farmacia WHERE funcionario.login = ? AND funcionario.senha = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, CriarCredenciais.hashSenha(senha));
        ResultSet logado = statement.executeQuery();

        if (logado.next()){
            //Criar nova query pra pegar nome da farmacia de onde ele trabalha
            return new Funcionario(logado.getString("nome"), logado.getString("nome_farmacia"),
                    logado.getInt("id_farmacia"), logado.getInt("cargo"));
        }else{
            return new Funcionario("Erro", "Erro", 0, -1);
        }
    }

}
