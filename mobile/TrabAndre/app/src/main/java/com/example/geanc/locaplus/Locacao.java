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

import com.example.geanc.locaplus.Entidades.Conta;
import com.example.geanc.locaplus.Persistencia.Banco;

import java.util.LinkedList;
import java.util.List;

public class Locacao extends AppCompatActivity {
    private ListView lista;
    private SQLiteDatabase conexao;
    private Banco bd;

    private List listar(){
        conexao=bd.getReadableDatabase();
        List locacoes = new LinkedList();
        Cursor res= conexao.rawQuery("SELECT * FROM LOCACAO", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                com.example.geanc.locaplus.Entidades.Locacao p = new com.example.geanc.locaplus.Entidades.Locacao();
                p.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                p.setNome(res.getString(res.getColumnIndexOrThrow("NOME_AUTOMOVEL")));
                p.setPlaca(res.getString(res.getColumnIndexOrThrow("PLACA_AUTOMOVEL")));
                p.setMarca(res.getString(res.getColumnIndexOrThrow("MARCA_AUTOMOVEL")));
                p.setModelo(res.getString(res.getColumnIndexOrThrow("MODELO")));
                p.setCor(res.getString(res.getColumnIndexOrThrow("COR")));
                p.setDataLocacao(res.getString(res.getColumnIndexOrThrow("DATA_LOCACAO")));
                p.setDataDevolucao(res.getString(res.getColumnIndexOrThrow("DATA_DEVOLUCAO")));
                p.setValorSeguro(res.getFloat(res.getColumnIndexOrThrow("VALOR_SEGURO")));
                p.setValorLocacao(res.getFloat(res.getColumnIndexOrThrow("VALOR_LOCACAO")));
                locacoes.add(p);
            }while (res.moveToNext());
        }
        return  locacoes;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacao);
        lista = findViewById(R.id.lista_Locacoes);
        acoes();
        conexaoBD();
    }
    public void acCad(View view){
        Intent it = new Intent(this, CadLocacao.class);
        startActivity(it);
    }
    public void sair(View view){
        this.finish();
    }
    private void acoes() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Locacao.this, CadLocacao.class);
                com.example.geanc.locaplus.Entidades.Locacao locacao = (com.example.geanc.locaplus.Entidades.Locacao) adapterView.getItemAtPosition(i);
                it.putExtra("locacao", locacao);
                startActivity(it);
                /*Bundle bundle = new Bundle();
                bundle.putSerializable("pessoa",pessoa);
                it.putExtras(bundle);*/
                // it.putExtras("pessoa", pessoa);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        //lista itermediario listview
        ArrayAdapter<com.example.geanc.locaplus.Entidades.Locacao> arrayAdapter = new ArrayAdapter<com.example.geanc.locaplus.Entidades.Locacao>(this,android.R.layout.simple_list_item_1, listar());
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
