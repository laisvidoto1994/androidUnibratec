package com.unibratec.laisvidoto.applicationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView nome;
        TextView telefone;
        ImageView imagem;
        Button botao;

        nome = (TextView)findViewById(R.id.textView_Nome);
        telefone = (TextView)findViewById(R.id.textView_Telefone);
        imagem = (ImageView)findViewById(R.id.imageView2);
        botao = (Button) findViewById(R.id.adicionar) ;

        nome.setText("teste".toString());
        telefone.setText("99848-9804".toString());

        imagem.setImageResource(R.drawable.buda);

        botao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


            }
        });

    }
}
