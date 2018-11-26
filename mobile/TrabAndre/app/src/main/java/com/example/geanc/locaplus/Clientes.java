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
import com.example.geanc.locaplus.Persistencia.Banco;

import java.util.LinkedList;
import java.util.List;

public class Clientes extends AppCompatActivity {
    private ListView lista;
    private SQLiteDatabase conexao;
    private Banco bd;

    private List listar(){
        conexao=bd.getReadableDatabase();
        List pessoas = new LinkedList();
        Cursor res= conexao.rawQuery("SELECT * FROM CLIENTE", null);
        if(res.getCount()>0){
            res.moveToFirst();
            do{
                Cliente p = new Cliente();
                p.setId(res.getInt(res.getColumnIndexOrThrow("ID")));
                p.setNome(res.getString(res.getColumnIndexOrThrow("NOME")));
                p.setCpf(res.getString(res.getColumnIndexOrThrow("CPF")));
                p.setRg(res.getString(res.getColumnIndexOrThrow("RG")));
                p.setEndereco(res.getString(res.getColumnIndexOrThrow("ENDERECO")));
                p.setCnh(res.getString(res.getColumnIndexOrThrow("CNH")));
                p.setDependentes(res.getInt(res.getColumnIndexOrThrow("DEPENDENTES")));
                pessoas.add(p);
            }while (res.moveToNext());
        }
        return  pessoas;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        lista = findViewById(R.id.ListaClientes);

        acoes();
        conexaoBD();
    }
    private void acoes() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Clientes.this, CadCliente.class);
                Cliente pessoa = (Cliente)adapterView.getItemAtPosition(i);
                it.putExtra("cliente", pessoa);
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
        ArrayAdapter<Cliente> arrayAdapter = new ArrayAdapter<Cliente>(this,android.R.layout.simple_list_item_1, listar());
        lista.setAdapter(arrayAdapter);
    }
    public void acCad(View view){
        Intent it = new Intent(this, CadCliente.class);
        startActivity(it);
    }
    public void sair(View view){
        this.finish();
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
