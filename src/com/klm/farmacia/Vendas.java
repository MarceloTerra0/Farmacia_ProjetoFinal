//+1 nas compras do cliente
//Adicionar dinheiro na farmacia
//Adicionar comissao ao funcionario que vendeu
//Retirar item Armazem

package com.klm.farmacia;

import com.klm.farmacia.obj.Produto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
public class Vendas {

    //Necessária a limpeza da função, porém a funcionalidade está ok
    public static String finalizarVenda(int idFuncionario, int idCliente, int idFarmacia, int comprasCliente
            , BigDecimal valorCompraTotal, BigDecimal valorCompraDesconto,
                                        List<Produto> listaProdutos, List<Integer> qtdProdutoVendido, Connection connection) throws SQLException {

        int idVenda;
    String sql = "SELECT id FROM historico_vendas ORDER BY id DESC LIMIT 1";
    PreparedStatement statement0 = connection.prepareStatement(sql);
    ResultSet resultSet0 = statement0.executeQuery();
    if(resultSet0.next()) {
        idVenda = resultSet0.getInt("id") + 1;
    }else{
        idVenda = 1;
    }


    //Trecho cuidando da tabela de vendas
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
            statement.setInt(i*3+2, listaProdutos.get(i).getIdProduto());
            statement.setInt(i*3+3, qtdProdutoVendido.get(i));

            Armazem.retiraItemArmazem(listaProdutos.get(i), qtdProdutoVendido.get(i), connection);
        }
        int rows = statement.executeUpdate();

        if (rows>0){
            System.out.println("Compra realizada com sucesso");
        }else{
            System.out.println("Erro ao finalizar a venda");
        }
    //Trecho cuidando da tabela historico_vendas
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
        statement1.setBigDecimal(7, valorCompraDesconto);
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
            System.out.println("update ++ qtd_compra cliente");
        }else{
            System.out.println("ERRO AO: update ++ qtd_compra cliente");
        }

        //Comissão funcionario
        String sql3 = "UPDATE funcionario SET comissao = ? WHERE id = ?";
        statement.close();
        statement1.close();
        return ("");
    }

    public static String mostrarHistoricoVendasId(Connection connection, int pagina, int id, String escolha) throws SQLException {
        String historicoVendasStr = "ID Venda - ID Farmacia - ID Funcionario - ID Cliente - Data - Valor Total - Valor Descontado\n";
        String SQLVendas;
        if(escolha.equals("funcionario")){
            SQLVendas = "SELECT * FROM historico_vendas WHERE id_funcionario = ? ORDER BY id LIMIT ?, ?;";
        }else{
            SQLVendas = "SELECT * FROM historico_vendas WHERE id_cliente = ? ORDER BY id LIMIT ?, ?;";
        }

        PreparedStatement SQLhistoricoVendas = connection.prepareStatement(SQLVendas);
        SQLhistoricoVendas.setInt(1, id);
        SQLhistoricoVendas.setInt(2, 10 * (pagina-1));
        SQLhistoricoVendas.setInt(3, 10 * pagina);
        ResultSet historicoVendas = SQLhistoricoVendas.executeQuery();
        while(historicoVendas.next()){
            int idVenda = historicoVendas.getInt("id");
            int idFarmacia = historicoVendas.getInt("id_farmacia");
            int idFuncionario = historicoVendas.getInt("id_funcionario");
            int idCliente = historicoVendas.getInt("id_cliente");
            java.sql.Date dbSqlDate = historicoVendas.getDate("dataVenda");
            BigDecimal valorTotal = historicoVendas.getBigDecimal("valor_total");
            BigDecimal valorDescontoAplicado = historicoVendas.getBigDecimal("valor_desconto_aplicado");


            historicoVendasStr =
                    historicoVendasStr
                    + idVenda + ") "
                    + idFarmacia + " "
                    + idFuncionario + " "
                    + idCliente + " "
                    + dbSqlDate.toString() + " R$"
                    + valorTotal.toString() + " R$"
                    + valorDescontoAplicado.toString() + "\n";
        }
        historicoVendas.close();
        return(historicoVendasStr);
    }
}
