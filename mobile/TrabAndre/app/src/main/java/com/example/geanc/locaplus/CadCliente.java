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

import com.example.geanc.locaplus.Entidades.Cliente;
import com.example.geanc.locaplus.Persistencia.Banco;

public class CadCliente extends AppCompatActivity {
    private EditText nome;
    private EditText cpf;
    private EditText rg;
    private EditText endereco;
    private EditText cnh;
    private EditText dependentes;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);
        nome=findViewById(R.id.edNome_Locacao);
        cpf=findViewById(R.id.edCPF);
        rg=findViewById(R.id.edRG);
        endereco=findViewById(R.id.edEndereco);
        cnh=findViewById(R.id.edCNH);
        dependentes=findViewById(R.id.edDependentes);
        cliente=(Cliente) getIntent().getSerializableExtra("cliente");
        if(cliente!=null){

            nome.setText(cliente.getNome());
            cpf.setText(cliente.getCpf());
            rg.setText(cliente.getRg());
            endereco.setText(cliente.getEndereco());
            cnh.setText(cliente.getCnh());
            dependentes.setText(cliente.getDependentes().toString());
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
        if(TextUtils.isEmpty(cpf.getText())){
            Toast.makeText(this,"Entre com o cpf",Toast.LENGTH_LONG).show();
            cpf.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(rg.getText())){
            Toast.makeText(this,"Entre com o rg",Toast.LENGTH_LONG).show();
            rg.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(cnh.getText())){
            Toast.makeText(this,"Entre com  cnh",Toast.LENGTH_LONG).show();
            cnh.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(endereco.getText())){
            Toast.makeText(this,"Entre com o endereço",Toast.LENGTH_LONG).show();
            endereco.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(dependentes.getText())){
            Toast.makeText(this,"Entre com a quantidade de dependentes",Toast.LENGTH_LONG).show();
            dependentes.requestFocus();
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
            values.put("NOME",cliente.getNome());
            values.put("CPF",cliente.getCpf());
            values.put("RG",cliente.getRg());
            values.put("CNH",cliente.getCnh());
            values.put("DEPENDENTES",cliente.getDependentes());
            values.put("ENDERECO",cliente.getEndereco());
            if(cliente.getId()<=0){
                conexao.insertOrThrow("CLIENTE",null,values);}
            else{
                conexao.update("CLIENTE",values,"ID=?",new String[]{cliente.getId()+""});}

            conexao.close();

            Toast.makeText(this, "Sucesso",Toast.LENGTH_LONG).show();
        }catch ( SQLException ex){
            Toast.makeText(this, "erro na inserção",Toast.LENGTH_LONG).show();
        }

    }
    public void apagar(View view) {
        if(cliente == null){
            Toast.makeText(this, "Cliente não cadastrado ainda", Toast.LENGTH_LONG).show();
            finish();
        }else{
        bd = new Banco(this);
        // String sql= "INSERT INTO PESSOA(NOME,TELEFONE,IDADE )VALUES('"+pessoa.getNome()+"','"+pessoa.getNome()+"',"+pessoa.getIdade()+")";
        try {
            conexao = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("NOME", cliente.getNome());
            values.put("CPF", cliente.getCpf());
            values.put("RG", cliente.getRg());
            values.put("CNH", cliente.getCnh());
            values.put("DEPENDENTES", cliente.getDependentes());
            values.put("ENDERECO", cliente.getEndereco());
            if (cliente.getId() > 0) {
                conexao.delete("CLIENTE", "ID=?", new String[]{cliente.getId() + ""});
                Toast.makeText(this, "Cliente Excluido com Sucesso", Toast.LENGTH_LONG).show();
                finish();
            }
            else if(cliente.getId()<=0){
                    Toast.makeText(this, "Cliente não cadastrado ainda", Toast.LENGTH_LONG).show();
                    finish();
                }
                conexao.close();
                finish();
            }catch(SQLException ex){
                Toast.makeText(this, "Erro na exlusão", Toast.LENGTH_LONG).show();
                finish();
            }

        }
    }

    public void salvar(View view){

        if(valida()){
            if(cliente==null) cliente=new Cliente();
            cliente.setNome(nome.getText().toString());
            cliente.setDependentes(Integer.parseInt(dependentes.getText().toString()));
            cliente.setEndereco(endereco.getText().toString());
            cliente.setCpf(cpf.getText().toString());
            cliente.setRg(rg.getText().toString());
            cliente.setCnh(cnh.getText().toString());
            inserir();
            finish();
        }
    }
}
