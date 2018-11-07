package com.example.aluno.application2;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //acessar identy
        Intent it = getIntent();

        //pegar o valor da chave
        String nomes = it.getStringExtra("nome_app");

        //alimentar o tesxtView
        EditText tx = (EditText)findViewById(R.id.editText);
        tx.setText(nomes);


    }

}
