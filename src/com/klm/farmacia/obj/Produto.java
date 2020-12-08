package com.klm.farmacia.obj;

import java.math.BigDecimal;

public class Produto {
    String nomeProduto;
    int idFarmacia, qtdEstoque, idProduto;
    BigDecimal precoProduto;

    public Produto(String nomeProduto, int idFarmacia, int qtdEstoque, BigDecimal precoProduto, int idProduto){
        this.nomeProduto = nomeProduto;
        this.idFarmacia = idFarmacia;
        this.qtdEstoque = qtdEstoque;
        this.precoProduto = precoProduto;
        this.idProduto = idProduto;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }
}
