package com.klm.farmacia.obj;

public class Funcionario {
    String nomeFuncionario, nomeFarmacia;
    int idFarmacia, idCargo, idFuncionario;

    public Funcionario(String nomeFuncionarioP, String nomeFarmaciaP, int idFarmaciaP, int idCargoP, int idFunc){
        this.nomeFuncionario = nomeFuncionarioP;
        this.nomeFarmacia = nomeFarmaciaP;
        this.idFarmacia = idFarmaciaP;
        this.idCargo = idCargoP;
        this.idFuncionario = idFunc;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getNomeFarmacia() {
        return nomeFarmacia;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
}
