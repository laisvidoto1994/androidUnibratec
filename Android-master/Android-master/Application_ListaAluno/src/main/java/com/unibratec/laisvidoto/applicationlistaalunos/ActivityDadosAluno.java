package com.unibratec.laisvidoto.applicationlistaalunos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/*
                        Tela 2
*/
public class ActivityDadosAluno extends AppCompatActivity
{
    EditText mEdtNome;
    EditText mEdtTelefone;
    EditText mEdtEnderreco;
    EditText mEdtFoto;
    EditText mEdtSitePessoal;
    EditText mEdtNota;
    Button mBtnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_aluno);

        mEdtNome        = (EditText)findViewById( R.id.edt_name );
        mEdtTelefone    = (EditText)findViewById( R.id.edt_telefone );
        mEdtEnderreco   = (EditText)findViewById( R.id.edt_endereco );
        mEdtFoto        = (EditText)findViewById( R.id.edt_foto );
        mEdtSitePessoal = (EditText)findViewById( R.id.edt_site_pessoal );
        mEdtNota        = (EditText)findViewById( R.id.edt_nota );
        mBtnSalvar      = (Button)findViewById( R.id.btn_salvar );
        mBtnSalvar.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nome        = mEdtNome.getText().toString();
                int telefone       = Integer.parseInt( mEdtTelefone.getText().toString() );
                String enderreco   = mEdtEnderreco.getText().toString();
                String foto        = mEdtFoto.getText().toString();
                String sitePessoal = mEdtSitePessoal.getText().toString();
                Double nota        = Double.parseDouble( mEdtNota.getText().toString() );

                Student student = new Student( nome, telefone, enderreco, foto, sitePessoal, nota );

                Intent it = new Intent();
                it.putExtra( "student", student );
                setResult( 1, it );
                finish();

            }
        });
        Log.d( "Tela 2","onCreate" );
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d( "Tela 2","onStart" );
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d( "Tela 2","onResume" );
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d( "Tela 2","onPause" );
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d( "Tela 2","onStop" );
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d( "Tela 2","onRestart" );
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d( "Tela 2","onDestroy" );
    }
}
