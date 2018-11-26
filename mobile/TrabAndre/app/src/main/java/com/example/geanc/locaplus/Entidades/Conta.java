package com.example.geanc.locaplus.Entidades;

import java.io.Serializable;


public class Conta implements Serializable {
    private Integer id;
    private String NomeConta;
    private float valor;
    private String DataPagamento;
    private String DataVencimento;
    private String Descricao;

    public Conta(){id=0;}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeConta() {
        return NomeConta;
    }

    public void setNomeConta(String nomeConta) {
        NomeConta = nomeConta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return DataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        DataPagamento = dataPagamento;
    }

    public String getDataVencimento() {
        return DataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        DataVencimento = dataVencimento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    public boolean equals(Object obj) {
        Conta c = (Conta) obj;
        if(c.getId().equals(this.getId()))
            return  true;
        return false;
    }

    @Override
    public String toString() {
        return "Id: "+this.getId()+"    Nome Conta: "+this.getNomeConta()+"\nValor: "+this.getValor()+"    Data de Vencimento: "+this.getDataVencimento();
    }
}
