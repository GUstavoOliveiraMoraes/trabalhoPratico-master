package com.example.geanc.locaplus.Entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;

    public  Pessoa(){
        id=0;
    }
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public boolean equals(Object obj) {
        Pessoa p = (Pessoa) obj;
        if(p.getId().equals(this.getId()))
            return  true;
        return false;
    }

}
