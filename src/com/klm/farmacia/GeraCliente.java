package com.klm.farmacia;

import com.klm.farmacia.obj.Cliente;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeraCliente {

    public static Cliente criaObjetoCliente(String cpf, Connection connection) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return(new Cliente(resultSet.getInt("id"), resultSet.getInt("quantidade_compras"),
            resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("cpf"))    );
        }else{
            return(new Cliente(-1, -1, "", "", ""));
        }
    }

    //retorna o valor já descontado
    public static BigDecimal calculaDesconto(Cliente cliente){
        if(cliente.getQuantidadeCompras() >= 20){
            return(new BigDecimal("0.90"));
        }else if(cliente.getQuantidadeCompras() >= 10){
            return(new BigDecimal("0.95"));
        }else{
            return(new BigDecimal("1"));
        }
    }
}
