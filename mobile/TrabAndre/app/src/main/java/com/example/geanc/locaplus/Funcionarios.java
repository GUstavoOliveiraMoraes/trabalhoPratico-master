package com.example.geanc.locaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Funcionarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);
    }
    public void sair(View v){
        this.finish();
    }

    public void novo(View v){
        Intent it = new Intent(this, CadFuncionario.class);
        startActivity(it);
    }
}
