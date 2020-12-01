
//Criar um produto novo na tabela produto
package com.klm.farmacia;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.math.BigDecimal;

public class Armazem {
    public static String consultaPrecoEEstoque(String nomeProduto, int idFarmacia, Connection connection) throws SQLException {
        String sql = "SELECT armazem.id_farmacia, produto.nome, produto.preco, armazem.qtd_produto FROM armazem JOIN produto WHERE produto.nome LIKE ? AND id_farmacia = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nomeProduto);
        statement.setInt(2, idFarmacia);
        ResultSet produto = statement.executeQuery();
        if(produto.next()){
            if(produto.getInt("qtd_produto") <=0){
                System.out.println("O produto não está em estoque");
            }else{
                System.out.println("Produto: '" + produto.getString("nome") +
                        "'\nPreço: RS" + produto.getBigDecimal("preco") +
                        "\nQuantidade no estoque: " + produto.getInt("qtd_produto"));
            }
        }
        return("");
    }

    public static String compraEstoque(int idCargo, int idFarmacia, Connection connection) throws SQLException {
        if (idCargo == 1){
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
                    System.out.println("Quantas unidades do produto '" + produto.getString("nome") + "' (R$" + produto.getBigDecimal("preco_fornecedor").toString() + ") devem ser compradas?");
                    escolha = scanner.nextInt();
                    if (preco.multiply(BigDecimal.valueOf(escolha)).compareTo(dinheiroFarmaciaValor) < 0){
                        System.out.println("Compra do produto realizada com sucesso! O valor gasto foi R$" + preco.multiply(BigDecimal.valueOf(escolha)).toString());
                        mensagem = "Compra do produto realizada com sucesso";
                    }else{
                        System.out.println("Dinheiro insuficiente para a compra, o dinheiro que a farmacia possui é de R$" + dinheiroFarmaciaValor.toString() + ". E o dinheiro necessário é R$" + preco.multiply(BigDecimal.valueOf(escolha)));
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

    public static String retiraItemArmazem(int idFarmacia, int idProduto, int quantidadeRemover, Connection connection) throws SQLException {
        String sql = "SELECT qtd_produto FROM armazem WHERE id_farmacia = ? AND id_produto = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idFarmacia);
        statement.setInt(2, idProduto);
        ResultSet produtoEstoque = statement.executeQuery();
        if(produtoEstoque.next()){
            int qtdProdutos = produtoEstoque.getInt("qtd_produto");
            if (quantidadeRemover > qtdProdutos){
                statement.close();
                return("Requerindo mais produtos do que existem no estoque");
            }else{
                statement.close();
                return("Itens removidos com sucesso");
            }
        }
        statement.close();
        return("Teste");
    }
}
