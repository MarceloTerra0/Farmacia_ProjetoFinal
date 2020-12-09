package com.klm.farmacia.obj;

import java.math.BigDecimal;
import java.sql.*;

//Classe não utilizada no projeto final. E por estar descontinuada,
//sua implementação provavelmente necessitaria de mudanças. (Também possui código para inserção de dados sem a UI)
public class HistoricoVendas {

    int idVenda, idFarmacia, idFuncionario, idCliente;
    Timestamp dataVenda;
    BigDecimal valorTotal, valorDescontoAplicado;

    //Código descontinuado
    public boolean refreshHistoricoVendas(ResultSet resultados) throws SQLException {
        if (resultados.next()) {
            return true;
        }
        else{
            return false;
        }
    }

    //Código descontinuado
    public HistoricoVendas(ResultSet resultados) throws SQLException {
        if (refreshHistoricoVendas(resultados)) {
            this.idVenda = resultados.getInt("id");
            this.idFarmacia = resultados.getInt("id_farmacia");
            this.idFuncionario = resultados.getInt("id_funcionario");
            this.idCliente = resultados.getInt("id_cliente");
            this.dataVenda = resultados.getTimestamp("dataVenda");
            this.valorTotal = resultados.getBigDecimal("valor_total");
            this.valorDescontoAplicado = resultados.getBigDecimal("valor_desconto_aplicado");
        }
    }

    public int getIdVenda(){
        return idVenda;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorDescontoAplicado() {
        return valorDescontoAplicado;
    }
}
