package com.example.geanc.locaplus.Entidades;

import java.io.Serializable;

public class Locacao implements Serializable {

    private Integer id;
    private String nome,placa,marca,modelo,cor,dataLocacao,dataDevolucao;
    private float valorLocacao,valorSeguro;

    public Locacao(){id=0;}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    @Override
    public boolean equals(Object obj) {
        Locacao p = (Locacao) obj;
        if(p.getId().equals(this.getId()))
            return  true;
        return false;
    }
    @Override
    public String toString() {
        return "Id: "+this.getId()+"    Nome: "+this.getNome()+"\nData Devolução: "+this.getDataDevolucao()+"    Data Locação: "+this.getDataLocacao();
    }
}
