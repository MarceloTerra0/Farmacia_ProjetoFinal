package com.klm.farmacia;

import com.klm.farmacia.obj.Produto;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.math.BigDecimal;

public class Armazem {

    public static String compraEstoque(int idCargo, int idFarmacia, Connection connection) throws SQLException {
        if (idCargo != 1){
            String mensagem;
            String sql = "SELECT dinheiro FROM farmacias WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idFarmacia);
            ResultSet dinheiroFarmacia = statement.executeQuery();
            if(dinheiroFarmacia.next()){
                BigDecimal dinheiroFarmaciaValor =  dinheiroFarmacia.getBigDecimal("dinheiro");
                System.out.println("A farmácia possui R$" + dinheiroFarmacia.getBigDecimal("dinheiro").toString());
                System.out.println("Digite o ID do produto a ser comprado para o estoque");
                Scanner scanner = new Scanner(System.in);
                int escolha = scanner.nextInt();
                sql = "SELECT * FROM produto WHERE id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, escolha);
                ResultSet produto = statement.executeQuery();
                if (produto.next()){
                    BigDecimal preco = produto.getBigDecimal("preco_fornecedor");
                    System.out.println("Quantas unidades do produto '" + produto.getString("nome") + "' (R$"
                            + produto.getBigDecimal("preco_fornecedor").toString() + ") devem ser compradas?");
                    escolha = scanner.nextInt();
                    if (preco.multiply(BigDecimal.valueOf(escolha)).compareTo(dinheiroFarmaciaValor) < 0){
                        System.out.println("Compra do produto realizada com sucesso! O valor gasto foi R$"
                                + preco.multiply(BigDecimal.valueOf(escolha)).toString());
                        mensagem = "Compra do produto realizada com sucesso";
                    }else{
                        System.out.println("Dinheiro insuficiente para a compra, o dinheiro que a farmacia possui é de R$"
                                + dinheiroFarmaciaValor.toString() + ". E o dinheiro necessário é R$"
                                + preco.multiply(BigDecimal.valueOf(escolha)));
                        mensagem = "Dinheiro insuficiente para a compra";
                    }
                }else{
                    mensagem = "Produto não encontrado";
                }
            }else{
                mensagem = "Farmácia não encontrada";
            }
            statement.close();
            return(mensagem);
        }else{
            return("Usuário sem permissão");
        }
    }

    public static String retiraItemArmazem(Produto produto, int quantidadeRemover, Connection connection) throws SQLException {
        String retiraItemArmazemSQL = "UPDATE armazem SET qtd_produto = ? WHERE(id_farmacia = ?) AND (id_produto = ?)";
        PreparedStatement retiraItemArmazemStatement = connection.prepareStatement(retiraItemArmazemSQL);
        retiraItemArmazemStatement.setInt(1, produto.getQtdEstoque() - quantidadeRemover);
        retiraItemArmazemStatement.setInt(2, produto.getIdFarmacia());
        retiraItemArmazemStatement.setInt(3, produto.getIdProduto());
        int rows = retiraItemArmazemStatement.executeUpdate();
        retiraItemArmazemStatement.close();
        System.out.println("Itens removidos com sucesso - " + rows);

        return("Teste");
    }

    public static String cadastrarNovoProduto(int idCargo, Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite o preço final produto");
        BigDecimal precoFinal = scanner.nextBigDecimal();
        System.out.println("Digite o preço do fornecedor do produto");
        BigDecimal precoFornecedor = scanner.nextBigDecimal();

        String sql = "INSERT INTO produto (nome, preco, preco_fornecedor) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nomeProduto);
        statement.setBigDecimal(2, precoFinal);
        statement.setBigDecimal(3, precoFornecedor);
        int rows = statement.executeUpdate();
        if (rows>0){
            System.out.println("Com sucesso");
        }else{
            System.out.println("Falha");
        }

        statement.close();
        return("");
    }

    public static Produto checaProdutoPeloNome(String nomeProduto, int idFarmacia,  Connection connection) throws SQLException {
        String checaProdutoPeloNomeSQL = "SELECT armazem.id_farmacia, produto.nome, produto.preco, armazem.qtd_produto, produto.id" +
                " FROM farmacia.armazem" +
                " INNER JOIN farmacia.produto ON armazem.id_produto = produto.id" +
                " WHERE produto.nome LIKE ? AND id_farmacia = ?";
        PreparedStatement checaProdutoPeloNomeStatement = connection.prepareStatement(checaProdutoPeloNomeSQL);
        checaProdutoPeloNomeStatement.setString(1, nomeProduto);
        checaProdutoPeloNomeStatement.setInt(2, idFarmacia);
        ResultSet produto = checaProdutoPeloNomeStatement.executeQuery();
        checaProdutoPeloNomeStatement.close();
        if(produto.next()){
            return (new Produto(produto.getString("nome"), produto.getInt("id_farmacia"),
                    produto.getInt("qtd_produto"), produto.getBigDecimal("preco"), produto.getInt("id")));
        }
        else{
            return (new Produto("", 0, -1, new BigDecimal("0"), 0));
        }
    }

    public static Produto checaProdutoPeloID(int idProduto, int idFarmacia,  Connection connection) throws SQLException {
        String checaProdutoPeloIdSQL = "SELECT armazem.id_farmacia, produto.nome, produto.preco, armazem.qtd_produto, produto.id" +
                " FROM farmacia.armazem" +
                " INNER JOIN farmacia.produto ON armazem.id_produto = produto.id" +
                " WHERE produto.id = ? AND id_farmacia = ?";
        PreparedStatement checaProdutoPeloIdStatement = connection.prepareStatement(checaProdutoPeloIdSQL);
        checaProdutoPeloIdStatement.setInt(1, idProduto);
        checaProdutoPeloIdStatement.setInt(2, idFarmacia);
        ResultSet produto = checaProdutoPeloIdStatement.executeQuery();
        checaProdutoPeloIdStatement.close();
        if(produto.next()){
            return (new Produto(produto.getString("nome"), produto.getInt("id_farmacia"),
                    produto.getInt("qtd_produto"), produto.getBigDecimal("preco"), produto.getInt("id")));
        }
        else{
            return (new Produto("", 0, -1, new BigDecimal("0"), 0));
        }

    }

}
