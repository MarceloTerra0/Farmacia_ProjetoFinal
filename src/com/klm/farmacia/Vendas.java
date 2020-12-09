//Adicionar dinheiro na farmacia

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
        BigDecimal comissao, dinheiroFarmacia;

        //Descobrindo ID da ultima compra (em historico_vendas) p/ usar na tabela "vendas"
        String ultimaVendaSQL = "SELECT id FROM historico_vendas ORDER BY id DESC LIMIT 1";
        PreparedStatement ultimaVendaStatement = connection.prepareStatement(ultimaVendaSQL);
        ResultSet ultimaVendaRS = ultimaVendaStatement.executeQuery();
        if(ultimaVendaRS.next()) {
            idVenda = ultimaVendaRS.getInt("id") + 1;
        }else{
            idVenda = 1;
        }
        ultimaVendaStatement.close();

        //Trecho cuidando da insercao de produtos na tabela de vendas - INICIO
        String vendaProduto = "INSERT INTO venda (id_venda, id_produto_vendido, qtd_produto_vendido) VALUES ";
        for(int i=0; i < listaProdutos.size(); i++) {
            if(i+1 == listaProdutos.size()) {
                vendaProduto = vendaProduto.concat("(?, ?, ?);");
            }else{
                vendaProduto = vendaProduto.concat("(?, ?, ?),");
            }
        }
        System.out.println(vendaProduto + " String be like " + listaProdutos.size());
        PreparedStatement vendaProdutoStatement = connection.prepareStatement(vendaProduto);
        for(int i=0; i < listaProdutos.size(); i++) {
            vendaProdutoStatement.setInt(i*3+1, idVenda);
            vendaProdutoStatement.setInt(i*3+2, listaProdutos.get(i).getIdProduto());
            vendaProdutoStatement.setInt(i*3+3, qtdProdutoVendido.get(i));

            Armazem.retiraItemArmazem(listaProdutos.get(i), qtdProdutoVendido.get(i), connection);
        }
        int rows1 = vendaProdutoStatement.executeUpdate();

        if (rows1>0){
            System.out.println("Compra realizada com sucesso");
        }else{
            System.out.println("Erro ao finalizar a venda");
        }
        vendaProdutoStatement.close();
        //Trecho cuidando da insercao de produtos na tabela de vendas - FINAL


        //Trecho cuidando da tabela historico_vendas - INICIO
        String vendaHistoricoVendas = "INSERT INTO historico_vendas (id, id_farmacia, id_funcionario, id_cliente, dataVenda, valor_total, valor_desconto_aplicado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement historicoVendasStatement = connection.prepareStatement(vendaHistoricoVendas);
        historicoVendasStatement.setInt(1, idVenda);
        historicoVendasStatement.setInt(2, idFarmacia);
        historicoVendasStatement.setInt(3, idFuncionario);
        historicoVendasStatement.setInt(4, idCliente);

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        historicoVendasStatement.setString(5, currentTime);

        historicoVendasStatement.setBigDecimal(6, valorCompraTotal);
        historicoVendasStatement.setBigDecimal(7, valorCompraDesconto);
        int rows2 = historicoVendasStatement.executeUpdate();
        if (rows2>0){
            System.out.println("foi");
        }

        String atualizarComprasClienteSQL = "UPDATE cliente SET quantidade_compras = ? WHERE id = ?";
        PreparedStatement atualizarComprasClienteStatement = connection.prepareStatement(atualizarComprasClienteSQL);
        atualizarComprasClienteStatement.setInt(1, comprasCliente+1);
        atualizarComprasClienteStatement.setInt(2, idCliente);
        int rows3 = atualizarComprasClienteStatement.executeUpdate();
        if (rows3>0){
            System.out.println("update ++ qtd_compra cliente");
        }else{
            System.out.println("ERRO AO: update ++ qtd_compra cliente");
        }
        historicoVendasStatement.close();
        atualizarComprasClienteStatement.close();
        //Trecho cuidando da tabela historico_vendas - FINAL


        //Trecho cuidando da comissao do(a) funcionario(a) - INICIO
        String acaharComissaoFuncionarioSQL = "SELECT comissao FROM funcionario WHERE id = ?";
        PreparedStatement acaharComissaoFuncionarioStatement = connection.prepareStatement(acaharComissaoFuncionarioSQL);
        acaharComissaoFuncionarioStatement.setInt(1, idFuncionario);
        ResultSet acaharComissaoFuncionarioRS = acaharComissaoFuncionarioStatement.executeQuery();
        if(acaharComissaoFuncionarioRS.next()) {
            comissao = acaharComissaoFuncionarioRS.getBigDecimal("comissao");
        }else{
            comissao = new BigDecimal("0");
            System.out.println("erro ao checar comissao (como ?) ");
        }
        String atualizarComissaoFuncionarioSQL = "UPDATE funcionario SET comissao = ? WHERE id = ?";
        PreparedStatement atualizarComissaoFuncionarioStatement = connection.prepareStatement(atualizarComissaoFuncionarioSQL);
        atualizarComissaoFuncionarioStatement.setBigDecimal(1, comissao.add(valorCompraTotal.multiply(new BigDecimal("0.01"))));
        atualizarComissaoFuncionarioStatement.setInt(2, idFuncionario);
        int rows4 = atualizarComissaoFuncionarioStatement.executeUpdate();
        if (rows4>0){
            System.out.println("sucesso ao adicionar comissao");
        }else{
            System.out.println("falha ao adicionar comissao");
        }
        acaharComissaoFuncionarioStatement.close();
        atualizarComissaoFuncionarioStatement.close();
        //Trecho cuidando da comissao do(a) funcionario(a) - FINAL


        //Adicionar valorCompraDescontado ao dinheiro da farmácia - INICIO
        String acharDinheiroFarmaciaSQL = "SELECT dinheiro FROM farmacias WHERE id_farmacia = ?";
        PreparedStatement acharDinheiroFarmaciaStatement = connection.prepareStatement(acharDinheiroFarmaciaSQL);
        acharDinheiroFarmaciaStatement.setInt(1, idFarmacia);
        ResultSet acharDinheiroFarmaciaRS = acharDinheiroFarmaciaStatement.executeQuery();
        if(acharDinheiroFarmaciaRS.next()) {
            dinheiroFarmacia = acharDinheiroFarmaciaRS.getBigDecimal("dinheiro");
        }else{
            dinheiroFarmacia = new BigDecimal("0");
        }

        String atualizarDinheiroFarmaciaSQL = "UPDATE farmacias SET dinheiro = ? WHERE id = ?";
        PreparedStatement atualizarDinheiroFarmaciaStatement = connection.prepareStatement(atualizarDinheiroFarmaciaSQL);
        atualizarDinheiroFarmaciaStatement.setBigDecimal(1, dinheiroFarmacia.add(valorCompraDesconto));
        atualizarDinheiroFarmaciaStatement.setInt(2, idFarmacia);
        int rows5 = atualizarDinheiroFarmaciaStatement.executeUpdate();
        if (rows5>0){
            System.out.println("sucesso ++ dinheiro farmacia");
        }else{
            System.out.println("deu ruim ++ dinheiro farmacia");
        }
        acharDinheiroFarmaciaStatement.close();
        atualizarDinheiroFarmaciaStatement.close();
        //Adicionar valorCompraDescontado ao dinheiro da farmácia - FINAL

        return ("Venda realizada com sucesso!");
    }

    public static String mostrarHistoricoVendasId(Connection connection, int pagina, int id, String escolha) throws SQLException {
        String historicoVendasStr;
        String SQLVendas;
        if(escolha.equals("funcionario")){
            SQLVendas = "SELECT * FROM historico_vendas WHERE id_funcionario = ? ORDER BY id LIMIT ?, ?;";
            historicoVendasStr = "ID Venda - ID Farmacia - ID Funcionario - Data - Valor Total - Valor Descontado\n";
        }else{
            SQLVendas = "SELECT * FROM historico_vendas WHERE id_cliente = ? ORDER BY id LIMIT ?, ?;";
            historicoVendasStr = "ID Venda - ID Farmacia - ID Cliente - Data - Valor Total - Valor Descontado\n";
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
