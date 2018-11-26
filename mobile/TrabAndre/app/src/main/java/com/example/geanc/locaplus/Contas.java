package com.example.geanc.locaplus;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.geanc.locaplus.Entidades.Cliente;
import com.example.geanc.locaplus.Entidades.Conta;
import com.example.geanc.locaplus.Persistencia.Banco;

import java.util.LinkedList;
import java.util.List;

public class Contas extends AppCompatActivity {
    private ListView lista;
    private SQLiteDatabase conexao;
    private Banco bd;

    private List listar(){
        conexao=bd.getReadableDatabase();
        List contas = new LinkedList();
        Cursor res= conexao.rawQuery("SELECT * FROM CONTA", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                Conta p = new Conta();
                p.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                p.setNomeConta(res.getString(res.getColumnIndexOrThrow("NOMECONTA")));
                p.setDataPagamento(res.getString(res.getColumnIndexOrThrow("DATAPAGAMENTO")));
                p.setDataVencimento(res.getString(res.getColumnIndexOrThrow("DATAVENCIMENTO")));
                p.setDescricao(res.getString(res.getColumnIndexOrThrow("DESCRICAO")));
                p.setValor(res.getFloat(res.getColumnIndexOrThrow("VALOR")));
                contas.add(p);
            }while (res.moveToNext());
        }
        return  contas;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas);
        lista = findViewById(R.id.ListaContas);
        acoes();
        conexaoBD();
    }
    private void acoes() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Contas.this, CadContas.class);
                Conta conta = (Conta)adapterView.getItemAtPosition(i);
                it.putExtra("conta", conta);
                startActivity(it);
                /*Bundle bundle = new Bundle();
                bundle.putSerializable("pessoa",pessoa);
                it.putExtras(bundle);*/
                // it.putExtras("pessoa", pessoa);
            }
        });
    }
    public void acCad(View view){
        Intent it = new Intent(this, CadContas.class);
        startActivity(it);
    }
    public void sair(View view){
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //lista itermediario listview
        ArrayAdapter<Conta> arrayAdapter = new ArrayAdapter<Conta>(this,android.R.layout.simple_list_item_1, listar());
        lista.setAdapter(arrayAdapter);
    }
    private void conexaoBD() {
        try {
            bd= new Banco(this);
            Toast.makeText(this,"Conexão ok",Toast.LENGTH_LONG).show();

        }catch (SQLException ex){
            AlertDialog.Builder msg= new AlertDialog.Builder(this);
            msg.setTitle("Erro");
            msg.setMessage("Erro de conexão");
            msg.setNegativeButton("ok",null);
            msg.show();
        }
    }
}
