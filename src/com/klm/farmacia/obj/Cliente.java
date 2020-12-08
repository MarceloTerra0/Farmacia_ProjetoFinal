package com.klm.farmacia.obj;

public class Cliente {
    int idCliente, quantidadeCompras;
    String nomeCliente, telefoneCliente, cpfCliente;

    public Cliente(int id, int qtdCompras, String nome, String telefone, String cpf){
        this.cpfCliente = cpf;
        this.idCliente = id;
        this.quantidadeCompras = qtdCompras;
        this.nomeCliente = nome;
        this.telefoneCliente = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getQuantidadeCompras() {
        return quantidadeCompras;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }
}
