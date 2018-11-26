package com.example.geanc.locaplus.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    public Banco(Context context) {
        super(context, "BANCO", null, 3);
    }

    String sql ="CREATE TABLE IF NOT EXISTS CLIENTE(" +"ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +"NOME VARCHAR(45),"
            +" CPF VARCHAR(15),"
            +"RG VARCHAR(15),"
            +"ENDERECO VARCHAR(60),"
            +"CNH VARCHAR(15),"
            + "DEPENDENTES INTEGER);";
    String sql2 = "CREATE TABLE IF NOT EXISTS CONTA(" +"ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +"NOMECONTA VARCHAR(45),"
            +"VALOR FLOAT,"
            +"DATAPAGAMENTO VARCHAR(15),"
            +"DATAVENCIMENTO VARCHAR(15),"
            +"DESCRICAO VARCHAR(50));";
    String sql3 ="CREATE TABLE IF NOT EXISTS AUTOMOVEL(" +"ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +"NOME_AUTOMOVEL VARCHAR(45),"
            +"PLACA_AUTOMOVEL VARCHAR(15),"
            +"MARCA_AUTOMOVEL VARCHAR(15),"
            +"MODELO VARCHAR(20),"
            +"COR VARCHAR(15),"
            +"VALOR_SEGURO FLOAT,"
            +"VALOR_LOCACAO FLOAT,"
            + "ATIVO VARCHAR(15));";  //aparentemente não existe boolean no metodo para pegar e inserir automaticamente no bd
    String sql4 ="CREATE TABLE IF NOT EXISTS FUNCIONARIO(" +"ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +"NOME VARCHAR(45),"
            +" CPF VARCHAR(15),"
            +"RG VARCHAR(15),"
            +"ENDERECO VARCHAR(60),"
            +"DATA_ADMISSAO VARCHAR(15),"
            +"DATA_DEMISSAO VARCHAR(15),"
            + "SUPERVISOR VARCHAR(15));";

    String sql5 ="CREATE TABLE IF NOT EXISTS LOCACAO(" +"ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +"NOME_AUTOMOVEL VARCHAR(45),"
            +"PLACA_AUTOMOVEL VARCHAR(15),"
            +"MARCA_AUTOMOVEL VARCHAR(15),"
            +"MODELO VARCHAR(20),"
            +"COR VARCHAR(15),"
            +"VALOR_SEGURO FLOAT,"
            +"DATA_LOCACAO VARCHAR(15),"
            +"DATA_DEVOLUCAO VARCHAR(15),"
            +"VALOR_LOCACAO FLOAT);";
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(sql); //tabela cliente
        sqLiteDatabase.execSQL(sql2); // tabela conta
        sqLiteDatabase.execSQL(sql3); // tabela automovel
        sqLiteDatabase.execSQL(sql4); //tabela funcionario
        sqLiteDatabase.execSQL(sql5); //tabela locação
        //StringBuilder stringBuilder= new StringBuilder();
        //stringBuilder.append("CREATE TABLE  IF NOT EXISTS PESSOA(");
        //stringBuilder.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        // stringBuilder.append("NOME TEXT);");
        //sqLiteDatabase.execSQL(stringBuilder.toString());

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //  String sql="ALTER TABLE PESSOA ADD IDADE INTEGER; ";
        /*String sql="ALTER TABLE CLIENTE ADD NOME VARCHAR(45);";
        String sql2="ALTER TABLE CLIENTE ADD CPF VARCHAR(15);";
        String sql3="ALTER TABLE CLIENTE ADD RG VARCHAR(15);";
        String sql4="ALTER TABLE CLIENTE ADD CNH VARCHAR(15);";
        String sql5="ALTER TABLE CLIENTE ADD ENDERECO VARCHAR(60);";
        String sql6="ALTER TABLE CLIENTE ADD DEPENDENTES INTEGER;";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql3);
        sqLiteDatabase.execSQL(sql4);
        sqLiteDatabase.execSQL(sql5);
        sqLiteDatabase.execSQL(sql6);*/

    }
}
