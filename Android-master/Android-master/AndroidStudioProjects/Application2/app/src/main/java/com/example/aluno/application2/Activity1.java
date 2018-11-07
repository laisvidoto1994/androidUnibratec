package com.example.aluno.application2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity
{

    /* ciclo de vida de uma activity   */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        if (savedInstanceState != null)
        {
            //ele pucha á palavra "chave" outState.putString("chave","minha app!");
            Toast.makeText(this,savedInstanceState.getString("chave"),Toast.LENGTH_LONG).show();
        }
        ListView lista = (ListView) findViewById(R.id.listView);

        Button botao1 = (Button)findViewById(R.id.button1);

        Button botao2 = (Button)findViewById(R.id.button2);
        botao2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Activity1.this, Activity2.class);
                it.putExtra("nome_app","app que funcionou");
                startActivity(it);
            }
        });

    }

    /*     */
    @Override
    protected void onStart()    {           super.onStart(); Log.d("lais","On Start");     }

    /*     */
    @Override
    protected void onPause()     {        super.onPause(); Log.d("lais","On Pause");   }

    /*    */
    @Override
    protected void onRestart() {        super.onRestart(); Log.d("lais","On Restart");   }

    /* fica á aplicação em 2º plano    */
    @Override
    protected void onStop()    {        super.onStop();  Log.d("lais","On Stop");  }

    /*    */
    @Override
    protected void onResume() {        super.onResume();  Log.d("lais","On Resume");  }

    /*  so para destruição  */
    @Override
    protected void onDestroy() {        super.onDestroy(); Log.d("lais","On Destroy");   }

    /*  */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString("chave","minha app!");
        super.onSaveInstanceState(outState);
        // lala
    }
/*
    public void botao2_clicado(View v)
    {
        Intent it = new Intent(this, Activity2.class);
        it.putExtra("nome_app","app que funcionou");
        startActivity(it);
    }
    */
}
