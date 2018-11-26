package com.example.geanc.locaplus.Entidades;

import java.io.Serializable;

public class Automovel implements Serializable {

    private Integer id;
    private String nome,placa,modelo,marca,cor;
    private float valorDoSeguro,valorDaLocacao;
    private String ativo;

    public Automovel(){id=0;}

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getValorDoSeguro() {
        return valorDoSeguro;
    }

    public void setValorDoSeguro(float valorDoSeguro) {
        this.valorDoSeguro = valorDoSeguro;
    }

    public float getValorDaLocacao() {
        return valorDaLocacao;
    }

    public void setValorDaLocacao(float valorDaLocacao) {
        this.valorDaLocacao = valorDaLocacao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object obj) {
        Automovel p = (Automovel) obj;
        if(p.getId().equals(this.getId()))
            return  true;
        return false;
    }
}
