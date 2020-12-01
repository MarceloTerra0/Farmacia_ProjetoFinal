//CRIAR OBJETO PARA RETORNAR HISTORICO DE VENDAS!

package com.klm.farmacia;
import java.sql.*;
import java.util.Scanner;
public class Vendas {

    //Essa função irá lidar do processo inteiro de venda, desde
    //a seleção de itens para a venda até a venda do produto.

    public static String finalizarVenda(int idFuncionario, int idCliente){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade ");
        return ("");
    }

    public static String[] mostrarHistoricoVendas(Connection connection) throws SQLException {
        String[] vendas = new String[10];
        int contador = 0;
        String SQLVendas = "SELECT * FROM historico_vendas ORDER BY id LIMIT 0, 10;";
        PreparedStatement SQLhistoricoVendas = connection.prepareStatement(SQLVendas);
        ResultSet historicoVendas = SQLhistoricoVendas.executeQuery();
        while(historicoVendas.next()){
            java.sql.Date dbSqlDate = historicoVendas.getDate("data");
            System.out.println(dbSqlDate);
            System.out.println(historicoVendas.getInt("id"));
            System.out.println(historicoVendas.getInt("id_farmacia"));
            System.out.println(historicoVendas.getInt("id_funcionario"));
            System.out.println(historicoVendas.getInt("id_cliente"));
            String[] resultados;
        }
        historicoVendas.close();
        return(vendas);
    }
}
