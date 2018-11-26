package com.example.geanc.locaplus;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geanc.locaplus.Entidades.Automovel;
import com.example.geanc.locaplus.Entidades.Conta;
import com.example.geanc.locaplus.Entidades.Locacao;
import com.example.geanc.locaplus.Persistencia.Banco;

public class CadLocacao extends AppCompatActivity {
    private EditText nome;
    private EditText placa;
    private EditText marca;
    private EditText modelo;
    private EditText cor;
    private EditText valorSeguro;
    private EditText valorLocacao;
    private EditText dataLocacao;
    private EditText dataDevolucao;
    Locacao locacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_locacao);
        nome = findViewById(R.id.edNome_Locacao);
        placa = findViewById(R.id.edPlaca);
        marca = findViewById(R.id.edPlaca);
        modelo = findViewById(R.id.edModelo);
        cor = findViewById(R.id.edCor);
        valorSeguro = findViewById(R.id.edValorseguro);
        valorLocacao = findViewById(R.id.edValorlocacao);
        dataLocacao = findViewById(R.id.edDatalocacao);
        dataDevolucao = findViewById(R.id.edDatadevolucao);
        locacao=(Locacao) getIntent().getSerializableExtra("locacao");
        if(locacao!=null){

            nome.setText(locacao.getNome());
            //valor.setText((int) conta.getValor());
            valorLocacao.setText(Float.toString(locacao.getValorLocacao()));
            valorSeguro.setText(Float.toString(locacao.getValorSeguro()));
            placa.setText(locacao.getPlaca());
            modelo.setText(locacao.getModelo());
            cor.setText(locacao.getCor());
            dataDevolucao.setText(locacao.getDataDevolucao());
            dataLocacao.setText(locacao.getDataLocacao());


        }

    }
    public void sair(View view) {
        finish();
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
        if(TextUtils.isEmpty(dataLocacao.getText())){
            Toast.makeText(this,"Entre com a data da locação",Toast.LENGTH_LONG).show();
            valorSeguro.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(dataDevolucao.getText())){
            Toast.makeText(this,"Entre com a data da devolução",Toast.LENGTH_LONG).show();
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
            values.put("NOME_AUTOMOVEL",locacao.getNome());
            values.put("COR",locacao.getCor());
            values.put("MARCA_AUTOMOVEL",locacao.getMarca());
            values.put("MODELO",locacao.getModelo());
            values.put("PLACA_AUTOMOVEL",locacao.getPlaca());
            values.put("DATA_LOCACAO",locacao.getDataDevolucao());
            values.put("DATA_DEVOLUCAO",locacao.getDataLocacao());
            values.put("VALOR_LOCACAO",locacao.getValorLocacao());
            values.put("VALOR_SEGURO",locacao.getValorSeguro());


            if(locacao.getId()<=0){
                conexao.insertOrThrow("LOCACAO",null,values);}
            else{
                conexao.update("LOCACAO",values,"ID=?",new String[]{locacao.getId()+""});}

            conexao.close();

            Toast.makeText(this, "Sucesso",Toast.LENGTH_LONG).show();
        }catch ( SQLException ex){
            Toast.makeText(this, "erro na inserção",Toast.LENGTH_LONG).show();
        }

    }
    public void salvar(View view){

        if(valida()){
            if(locacao==null) locacao=new Locacao();
            locacao.setNome(nome.getText().toString());
            locacao.setValorSeguro(Float.parseFloat(valorSeguro.getText().toString()));
            locacao.setValorLocacao(Float.parseFloat(valorLocacao.getText().toString()));
            locacao.setPlaca(placa.getText().toString());
            locacao.setMarca(marca.getText().toString());
            locacao.setModelo(modelo.getText().toString());
            locacao.setCor(cor.getText().toString());
            locacao.setDataDevolucao(dataDevolucao.getText().toString());
            locacao.setDataLocacao(dataLocacao.getText().toString());
            inserir();
            finish();
        }
    }
    public void apagar(View view) {
        if (locacao == null) {
            Toast.makeText(this, "Locação não cadastrada ainda", Toast.LENGTH_LONG).show();
            finish();
        } else {
            bd = new Banco(this);
            // String sql= "INSERT INTO PESSOA(NOME,TELEFONE,IDADE )VALUES('"+pessoa.getNome()+"','"+pessoa.getNome()+"',"+pessoa.getIdade()+")";
            try {
                conexao=bd.getWritableDatabase();
                ContentValues values= new ContentValues();
                values.put("NOME_AUTOMOVEL",locacao.getNome());
                values.put("COR",locacao.getCor());
                values.put("MARCA_AUTOMOVEL",locacao.getMarca());
                values.put("MODELO",locacao.getModelo());
                values.put("PLACA_AUTOMOVEL",locacao.getPlaca());
                values.put("DATA_LOCACAO",locacao.getDataDevolucao());
                values.put("DATA_DEVOLUCAO",locacao.getDataLocacao());
                values.put("VALOR_LOCACAO",locacao.getValorLocacao());
                values.put("VALOR_SEGURO",locacao.getValorSeguro());
                if (locacao.getId() > 0) {
                    conexao.delete("LOCACAO", "ID=?", new String[]{locacao.getId() + ""});
                    Toast.makeText(this, "Locação Excluida com Sucesso", Toast.LENGTH_LONG).show();
                    finish();
                } else if (locacao.getId() <= 0) {
                    Toast.makeText(this, "Locação não cadastrado ainda", Toast.LENGTH_LONG).show();
                    finish();
                }
                conexao.close();
                finish();
            } catch (SQLException ex) {
                Toast.makeText(this, "Erro na exlusão", Toast.LENGTH_LONG).show();
                finish();
            }

        }
    }
}
