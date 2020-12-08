//CRIAR OBJETO PARA RETORNAR HISTORICO DE VENDAS!
//+1 nas compras do cliente

package com.klm.farmacia;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
public class Vendas {

    //Essa função irá lidar do processo inteiro de venda, desde
    //a seleção de itens para a venda até a venda do produto.

    public static String finalizarVenda(int idFuncionario, int idCliente, int idVenda, int idFarmacia
            ,BigDecimal valorCompraTotal, List listaProdutos, List quantidadeProdutos
            ,Connection connection) throws SQLException {

        //Por mais que tal checagem seja redundante (ao menos deveria ser), estou deixando-a por propósitos de debug.
        if(listaProdutos.size() != quantidadeProdutos.size()){
            return ("Erro desconhecido ao finalizar a venda");
        }

        String vendaProduto = "INSERT INTO venda (id_venda, id_produto_vendido, qtd_produto_vendido) VALUES ";

        for(int i=0; i < listaProdutos.size(); i++) {
            if(i+1 == listaProdutos.size()) {
                vendaProduto = vendaProduto.concat("(?, ?, ?);");
            }else{
                vendaProduto = vendaProduto.concat("(?, ?, ?),");
            }
        }

        System.out.println(vendaProduto + " String be like " + listaProdutos.size());
        PreparedStatement statement = connection.prepareStatement(vendaProduto);
        for(int i=0; i < listaProdutos.size(); i++) {
            statement.setInt(i*3+1, idVenda);
            statement.setInt(i*3+2, (Integer) listaProdutos.get(i));
            statement.setInt(i*3+3, (Integer) quantidadeProdutos.get(i));
        }
        int rows = statement.executeUpdate();
        if (rows>0){
            if (rows != listaProdutos.size()) {
                System.out.println("Compra realizada com sucesso, porém erro ao inserir no banco de dados");
            }else{
                System.out.println("Compra realizada com sucesso");
            }
        }else{
            System.out.println("Erro ao finalizar a venda");
        }

        String vendaHistoricoVendas = "INSERT INTO historico_vendas (id, id_farmacia, id_funcionario, id_cliente, dataVenda, valor_total, valor_desconto_aplicado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement1 = connection.prepareStatement(vendaHistoricoVendas);
        statement1.setInt(1, idVenda);
        statement1.setInt(2, idFarmacia);
        statement1.setInt(3, idFuncionario);
        statement1.setInt(4, idCliente);

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        statement1.setString(5, currentTime);

        statement1.setBigDecimal(6, valorCompraTotal);
        BigDecimal valorDescontoAplicado;
        String SQLCliente = "SELECT quantidade_compras FROM cliente WHERE id = ?";
        PreparedStatement SQLClienteCompras = connection.prepareStatement(SQLCliente);
        SQLClienteCompras.setInt(1, idCliente);
        ResultSet clienteCompras = SQLClienteCompras.executeQuery();
        BigDecimal desconto = new BigDecimal("1");
        int comprasCliente=0;
        if(clienteCompras.next()) {
            comprasCliente = clienteCompras.getInt("quantidade_compras");
            System.out.println(clienteCompras.getInt("quantidade_compras"));
            if (comprasCliente >= 20) {
                desconto = new BigDecimal("0.90");
            } else if (comprasCliente >= 10) {
                desconto = new BigDecimal("0.95");
            }
        }

        valorDescontoAplicado = valorCompraTotal.multiply(desconto);
        statement1.setBigDecimal(7, valorDescontoAplicado);
        int rows1 = statement1.executeUpdate();
        if (rows1>0){
            System.out.println("foi");
        }
        String sql2 = "UPDATE cliente SET quantidade_compras = ? WHERE id = ?";
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.setInt(1, comprasCliente+1);
        statement2.setInt(2, idCliente);
        int rows2 = statement2.executeUpdate();
        if (rows2>0){
            System.out.println("aaa");
        }else{
            System.out.println("bbb");
        }

        statement.close();
        statement1.close();
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
