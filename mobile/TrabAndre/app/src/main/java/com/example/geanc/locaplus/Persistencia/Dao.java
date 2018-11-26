package com.example.geanc.locaplus.Persistencia;

import com.example.geanc.locaplus.Entidades.Cliente;

import java.util.LinkedList;
import java.util.List;

public class Dao {
    private static List lista;
    private static int indice;

    private Dao(){}

    public static void salvar(Cliente p){
        if(lista.contains(p))
            lista.set(lista.indexOf(p),p);
        else{
            p.setId(indice);
            lista.add(p);
            indice++;
        }
    }

    public static List getLista() {
        if(lista==null) {
            lista = new LinkedList();
            indice=0;
        }
        return lista;
    }
}
