package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity
{
    private EditText mEditText;

    public void inicial()
    {
        mEditText = (EditText) findViewById(R.id.editText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inicial();

        Intent intent = getIntent();
        if(intent != null)
        {
            String param = intent.getStringExtra("chave3");
        }
    }
}
