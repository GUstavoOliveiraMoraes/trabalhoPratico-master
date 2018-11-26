package com.example.geanc.locaplus;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geanc.locaplus.Entidades.Automovel;
import com.example.geanc.locaplus.Entidades.Cliente;
import com.example.geanc.locaplus.Persistencia.Banco;

public class CadAutomoveis extends AppCompatActivity {
    private EditText nome;
    private EditText placa;
    private EditText marca;
    private EditText modelo;
    private EditText cor;
    private EditText ativo;
    private EditText valorSeguro;
    private EditText valorLocacao;
    private  CheckBox checkBox;
    Automovel automovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_automoveis);
        nome = findViewById(R.id.edNome_Carro);
        placa = findViewById(R.id.edPlaca_Carro);
        marca = findViewById(R.id.edMarca_Carro);
        modelo = findViewById(R.id.edModelo_Carro);
        cor= findViewById(R.id.edCor_Carro);
        valorSeguro = findViewById(R.id.edValor_Seguro_Carro);
        valorLocacao = findViewById(R.id.edValor_Locacao_Carro);
        checkBox = findViewById(R.id.check_Ativo_Carro);
        automovel=(Automovel) getIntent().getSerializableExtra("automovel");
        if(automovel!=null){

            nome.setText(automovel.getNome());
            placa.setText(automovel.getPlaca());
            marca.setText(automovel.getMarca());
            modelo.setText(automovel.getModelo());
            cor.setText(automovel.getCor());
            valorLocacao.setText(((int) automovel.getValorDaLocacao()));
            valorSeguro.setText(((int) automovel.getValorDoSeguro()));
            if(checkBox.isChecked()){
                ativo.setText("Ativo");
            }else{
                ativo.setText("Não Ativo");
            }
        }
    }
    public void sair(View view){
        this.finish();
    }

    private boolean valida() {
        if(TextUtils.isEmpty(nome.getText())){
            Toast.makeText(this,"Entre com o nome",Toast.LENGTH_LONG).show();
            nome.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(placa.getText())){
            Toast.makeText(this,"Entre com a placa",Toast.LENGTH_LONG).show();
            placa.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(marca.getText())){
            Toast.makeText(this,"Entre com a marca",Toast.LENGTH_LONG).show();
            marca.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(modelo.getText())){
            Toast.makeText(this,"Entre com o modelo",Toast.LENGTH_LONG).show();
            modelo.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(cor.getText())){
            Toast.makeText(this,"Entre com a cor",Toast.LENGTH_LONG).show();
            cor.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(valorLocacao.getText())){
            Toast.makeText(this,"Entre com o valor da locação",Toast.LENGTH_LONG).show();
            valorLocacao.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(valorSeguro.getText())){
            Toast.makeText(this,"Entre com o valor do seguro",Toast.LENGTH_LONG).show();
            valorSeguro.requestFocus();
            return false;
        }

        return true;

    }
    private SQLiteDatabase conexao;
    private Banco bd;
    private void inserir(){
        bd=new Banco(this);
        // String sql= "INSERT INTO PESSOA(NOME,TELEFONE,IDADE )VALUES('"+pessoa.getNome()+"','"+pessoa.getNome()+"',"+pessoa.getIdade()+")";
        try {
            conexao=bd.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("NOME_AUTOMOVEL",automovel.getNome());
            values.put("PLACA_AUTOMOVEL",automovel.getPlaca());
            values.put("MARCA_AUTOMOVEL",automovel.getMarca());
            values.put("MODELO",automovel.getModelo());
            values.put("COR",automovel.getCor());
            values.put("VALOR_SEGURO",automovel.getValorDoSeguro());
            values.put("VALOR_LOCACAO",automovel.getValorDaLocacao());
            values.put("ATIVO",automovel.getAtivo());
            if(automovel.getId()<=0){
                conexao.insertOrThrow("AUTOMOVEL",null,values);}
            else{
                conexao.update("AUTOMOVEL",values,"ID=?",new String[]{automovel.getId()+""});}

            conexao.close();

            Toast.makeText(this, "Sucesso",Toast.LENGTH_LONG).show();
        }catch ( SQLException ex){
            Toast.makeText(this, "erro na inserção",Toast.LENGTH_LONG).show();
        }

    }
    public void salvar(View view){

        if(valida()){
            if(automovel==null) automovel=new Automovel();
            automovel.setNome(nome.getText().toString());
            automovel.setValorDoSeguro(Float.parseFloat(valorSeguro.getText().toString()));
            automovel.setValorDaLocacao(Float.parseFloat(valorLocacao.getText().toString()));
            automovel.setPlaca(placa.getText().toString());
            automovel.setMarca(marca.getText().toString());
            automovel.setModelo(modelo.getText().toString());
            automovel.setCor(cor.getText().toString());
            automovel.setAtivo(ativo.getText().toString());
            inserir();
            finish();
        }
    }
}
