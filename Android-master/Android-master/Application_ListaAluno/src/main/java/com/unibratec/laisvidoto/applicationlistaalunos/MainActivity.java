package com.unibratec.laisvidoto.applicationlistaalunos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/*
                            Exercicio 4

 1) Faça uma Activity com um Listview(MainAcitivity) de Students(listando apenas os nomes)
com um botão de adicionar novo aluno, este botão chamará outra activity(FormStudentActivity)
que tem o formulário para adicionar um Student.

 2)Pesquise sobre a função onCreateContextMenu() e faça com na MainActivity, na listagem dos
alunos, ao segurar o botão em um aluno apareça as seguintes opções.
    - Ligar para o aluno
    - Mandar SMS para o aluno
    - Ver localização no mapa
    - Acessar site do aluno
*/

public class MainActivity extends AppCompatActivity
{
    ListView mListView;
    List<Student> mListaStudantes;
    ArrayAdapter<Student> mAdapter;
    ImageButton mBtn_Adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.listaStudantes);

        mListaStudantes = new ArrayList<>();

        mAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, mListaStudantes);

        mListView.setAdapter(mAdapter);

        mBtn_Adicionar = (ImageButton) findViewById(R.id.Btn_adicionar);
        mBtn_Adicionar.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if ( view.getId() == R.id.Btn_adicionar )
                {
                    Intent intent = new Intent(MainActivity.this, ActivityDadosAluno.class);
                    intent.putExtra("codigo",1);
                    startActivityForResult( intent, 1 );
                }
            }
        });

        Log.d( "Tela 1","onCreate" );
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data )
    {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == 1 && resultCode == RESULT_OK )
        {
            Student student = data.getParcelableExtra("student");
            mListaStudantes.add(student);
            mAdapter.notifyDataSetChanged();//avisa que teve uma atualização ns lista
        }
        else if(requestCode == 2 && resultCode == RESULT_OK)
        {

        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d( "Tela 1","onStart" );
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d( "Tela 1","onResume" );
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d( "Tela 1","onPause" );
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d( "Tela 1","onStop" );
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

        Log.d( "Tela 1","onRestart" );
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d( "Tela 1","onDestroy" );
    }
}
