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

import com.example.geanc.locaplus.Entidades.Automovel;
import com.example.geanc.locaplus.Entidades.Cliente;
import com.example.geanc.locaplus.Persistencia.Banco;

import java.util.LinkedList;
import java.util.List;

public class Automoveis extends AppCompatActivity {
    private ListView lista;
    private SQLiteDatabase conexao;
    private Banco bd;

    private List listar(){ //instrução para listar a tabela do bd automovel
        conexao=bd.getReadableDatabase();
        List carros = new LinkedList();
        Cursor res= conexao.rawQuery("SELECT * FROM AUTOMOVEL", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                Automovel p = new Automovel();
                p.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                p.setNome(res.getString(res.getColumnIndexOrThrow("NOME_AUTOMOVEL")));
                p.setAtivo(res.getString(res.getColumnIndexOrThrow("ATIVO")));
                p.setCor(res.getString(res.getColumnIndexOrThrow("COR")));
                p.setMarca(res.getString(res.getColumnIndexOrThrow("MARCA_AUTOMOVEL")));
                p.setModelo(res.getString(res.getColumnIndexOrThrow("MODELO")));
                p.setPlaca(res.getString(res.getColumnIndexOrThrow("PLACA_AUTOMOVEL")));
                p.setValorDaLocacao(res.getFloat(res.getColumnIndexOrThrow("VALOR_LOCACAO")));
                p.setValorDoSeguro(res.getFloat(res.getColumnIndexOrThrow("VALOR_SEGURO")));
                carros.add(p);
            }while (res.moveToNext());
        }
        return  carros;
    }
    private void acoes() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Automoveis.this, CadAutomoveis.class);
                Automovel automovel = (Automovel)adapterView.getItemAtPosition(i);
                it.putExtra("automovel", automovel);
                startActivity(it);
                /*Bundle bundle = new Bundle();
                bundle.putSerializable("pessoa",pessoa);
                it.putExtras(bundle);*/
                // it.putExtras("pessoa", pessoa);
            }
        });
    }
    @Override
    protected void onResume() { // criando um adaptador para a lista do bd e listView
        super.onResume();
        //lista itermediario listview
        ArrayAdapter<Automovel> arrayAdapter = new ArrayAdapter<Automovel>(this,android.R.layout.simple_list_item_1, listar());
        lista.setAdapter(arrayAdapter);
    }
    private void conexaoBD() {  //criando a conexão com o BD
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automoveis);
        lista= findViewById(R.id.ListaAutomoveis);
        acoes(); //chamando os metodos no onCreate
        conexaoBD();
    }
    public void sair(View v){
        this.finish();
    }
    public void acCad(View view){
        Intent it = new Intent(this, CadAutomoveis.class);
        startActivity(it);
    }
}
