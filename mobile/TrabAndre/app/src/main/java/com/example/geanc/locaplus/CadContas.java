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


import com.example.geanc.locaplus.Entidades.Conta;
import com.example.geanc.locaplus.Persistencia.Banco;

public class CadContas extends AppCompatActivity {
    private EditText nome;
    private EditText valor;
    private EditText pagamento;
    private EditText vencimento;
    private EditText descricao;
    Conta conta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_contas);
        nome=findViewById(R.id.edNomeConta);
        valor = findViewById(R.id.edValorConta);
        pagamento = findViewById(R.id.edVencimento_Conta);
        vencimento = findViewById(R.id.edPagamento_Conta);
        descricao = findViewById(R.id.edDecricao);
        conta=(Conta) getIntent().getSerializableExtra("conta");
        if(conta!=null){

            nome.setText(conta.getNomeConta());
            //valor.setText((int) conta.getValor());
            valor.setText(Float.toString(conta.getValor()));
            pagamento.setText(conta.getDataPagamento());
            vencimento.setText(conta.getDataVencimento());
            descricao.setText(conta.getDescricao());


        }
    }

    private boolean valida() {
        if(TextUtils.isEmpty(nome.getText())){
            Toast.makeText(this,"Entre com o nome",Toast.LENGTH_LONG).show();
            nome.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(valor.getText())){
            Toast.makeText(this,"Entre com o valor",Toast.LENGTH_LONG).show();
            valor.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(pagamento.getText())){
            Toast.makeText(this,"Entre com a Data de Pagamento",Toast.LENGTH_LONG).show();
            pagamento.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(vencimento.getText())){
            Toast.makeText(this,"Entre com a Data de Vencimento",Toast.LENGTH_LONG).show();
            vencimento.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(descricao.getText())){
            Toast.makeText(this,"Entre com a descrição da conta",Toast.LENGTH_LONG).show();
            descricao.requestFocus();
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
            values.put("NOMECONTA",conta.getNomeConta());
            values.put("DATAPAGAMENTO",conta.getDataPagamento());
            values.put("DATAVENCIMENTO",conta.getDataVencimento());
            values.put("VALOR",conta.getValor());
            values.put("DESCRICAO",conta.getDescricao());

            if(conta.getId()<=0){
                conexao.insertOrThrow("CONTA",null,values);}
            else{
                conexao.update("CONTA",values,"ID=?",new String[]{conta.getId()+""});}

            conexao.close();

            Toast.makeText(this, "Sucesso",Toast.LENGTH_LONG).show();
        }catch ( SQLException ex){
            Toast.makeText(this, "erro na inserção",Toast.LENGTH_LONG).show();
        }

    }
    public void apagar(View view) {
        if (conta == null) {
            Toast.makeText(this, "Conta não cadastrada ainda", Toast.LENGTH_LONG).show();
            finish();
        } else {
            bd = new Banco(this);
            // String sql= "INSERT INTO PESSOA(NOME,TELEFONE,IDADE )VALUES('"+pessoa.getNome()+"','"+pessoa.getNome()+"',"+pessoa.getIdade()+")";
            try {
                conexao = bd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("NOME_CONTA", conta.getNomeConta());
                values.put("DATA_PAGAMENTO", conta.getDataPagamento());
                values.put("DATA_VENCIMENTO", conta.getDataVencimento());
                values.put("VALOR_CONTA", conta.getValor());
                values.put("DESCRICAO", conta.getDescricao());
                if (conta.getId() > 0) {
                    conexao.delete("CONTA", "ID=?", new String[]{conta.getId() + ""});
                    Toast.makeText(this, "Conta Excluida com Sucesso", Toast.LENGTH_LONG).show();
                    finish();
                } else if (conta.getId() <= 0) {
                    Toast.makeText(this, "Conta não cadastrado ainda", Toast.LENGTH_LONG).show();
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
    public void sair(View v){
        this.finish();
    }
    public void salvar(View view){

        if(valida()){
            if(conta==null) conta=new Conta();
            conta.setNomeConta(nome.getText().toString());
            conta.setValor(Float.parseFloat(valor.getText().toString()));
            conta.setDescricao(descricao.getText().toString());
            conta.setDataVencimento(vencimento.getText().toString());
            conta.setDataPagamento(pagamento.getText().toString());

            inserir();
            finish();
        }
    }
}
