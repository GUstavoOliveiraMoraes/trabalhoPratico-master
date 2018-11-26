package com.example.geanc.locaplus.Entidades;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private String cnh;
    private Integer dependentes;


    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }
    @Override
    public boolean equals(Object obj) {
        Cliente c = (Cliente) obj;
        if(c.getId().equals(this.getId()))
            return  true;
        return false;
    }

    @Override
    public String toString() {
        return "Id: "+this.getId()+"    Nome: "+this.getNome()+"\nCPF: "+this.getCpf()+"    CNH: "+this.getCnh();
    }
}
